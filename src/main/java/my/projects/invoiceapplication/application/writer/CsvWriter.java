package my.projects.invoiceapplication.application.writer;

import my.projects.invoiceapplication.application.entity.Address;
import my.projects.invoiceapplication.application.entity.Customer;
import my.projects.invoiceapplication.application.entity.Invoice;
import my.projects.invoiceapplication.application.util.Notifications;
import my.projects.invoiceapplication.application.util.WriterFactory;

import java.io.*;
import java.nio.file.Path;
import java.util.List;

public class CsvWriter extends WriterSupport implements FileWriter {

    @Override
    public void write(List entities, Path path) {
        StringBuilder dataToWrite = new StringBuilder();
        String[] headerArray = WriterFactory.getHeader(entities.get(0));

        for (int i = 0; i < headerArray.length; i++) {
            if (i < headerArray.length - 1)
                dataToWrite.append("\"").append(headerArray[i]).append("\",");
            else
                dataToWrite.append("\"").append(headerArray[i]).append("\"\r\n");
        }

        dataToWrite.append(prepareDataToWrite(entities));

        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path.toString()), "UTF-8"));
            bufferedWriter.write(dataToWrite.toString());
        } catch (IOException e) {
            Notifications.showCanNotWriteToFileErrorMessage();
        } finally {
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.flush();
                    bufferedWriter.close();
                } catch (IOException e) {
                    Notifications.showCanNotCloseBufferWriterErrorMessage();
                }
            }
        }
    }

    @Override
    protected StringBuilder prepareDataToWrite(List entities) {
        StringBuilder builder = new StringBuilder();

        for (Object entity : entities) {
            if (entity instanceof Invoice) builder.append(((Invoice) entity).toCsv());
            else if (entity instanceof Customer) builder.append(((Customer) entity).toCsv());
            else if (entity instanceof Address) builder.append(((Address) entity).toCsv());
        }

        return builder;
    }
}
