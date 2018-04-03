package my.projects.invoiceapplication.application.writer;

import my.projects.invoiceapplication.application.entity.Address;
import my.projects.invoiceapplication.application.entity.Customer;
import my.projects.invoiceapplication.application.entity.Invoice;
import my.projects.invoiceapplication.application.util.Notifications;
import my.projects.invoiceapplication.application.util.WriterFactory;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.util.LinkedList;
import java.util.List;

public class XlsWriter extends WriterSupport implements FileWriter {

    @Override
    public void write(List entities, Path path) {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Sheet");

        createHeader(sheet, WriterFactory.getHeader(entities.get(0)));
        fillSheet(sheet, entities);

        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(new File(path.toString()));
            workbook.write(outputStream);
            workbook.close();
        } catch (IOException e) {
            Notifications.showCanNotWriteToFileErrorMessage();
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.flush();
                    outputStream.close();
                } catch (IOException e) {
                    Notifications.showCanNotCloseBufferWriterErrorMessage();
                }
            }
        }
    }

    private void createHeader(XSSFSheet sheet, String[] headerArray) {
        Row headerRow = sheet.createRow(0);
        int colCount = 0;
        for (String header : headerArray) {
            Cell cell = headerRow.createCell(colCount);
            cell.setCellValue(header);
            sheet.autoSizeColumn(colCount);
            colCount++;
        }
    }

    private void fillSheet(XSSFSheet sheet, List entities) {
        int rowCount = 1;
        List<String[]> listOfArrays = prepareDataToWrite(entities);
        for (String[] array : listOfArrays) {
            int colCount = 0;
            Row row = sheet.createRow(rowCount);

            for (String cellValue : array) {
                sheet.autoSizeColumn(colCount);
                Cell cell = row.createCell(colCount);
                cell.setCellValue(cellValue);
                colCount++;
            }

            rowCount++;
        }
    }

    @Override
    protected List<String[]> prepareDataToWrite(List entities) {
        List<String[]> outputList = new LinkedList<>();

        for (Object entity : entities) {
            if (entity instanceof Invoice) outputList.add(((Invoice) entity).toStringArray());
            else if (entity instanceof Customer) outputList.add(((Customer) entity).toStringArray());
            else if (entity instanceof Address) outputList.add(((Address) entity).toStringArray());
        }

        return  outputList;
    }

}
