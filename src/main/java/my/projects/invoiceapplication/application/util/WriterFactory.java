package my.projects.invoiceapplication.application.util;

import my.projects.invoiceapplication.application.entity.Address;
import my.projects.invoiceapplication.application.entity.Customer;
import my.projects.invoiceapplication.application.entity.Invoice;
import my.projects.invoiceapplication.application.service.AddressService;
import my.projects.invoiceapplication.application.service.CustomerService;
import my.projects.invoiceapplication.application.service.InvoiceService;
import my.projects.invoiceapplication.application.writer.FileWriter;
import org.assertj.core.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Component
public class WriterFactory {

    private final InvoiceService invoiceService;
    private final CustomerService customerService;
    private final AddressService addressService;

    @Autowired
    public WriterFactory(InvoiceService invoiceService,
                         CustomerService customerService,
                         AddressService addressService) {
        this.invoiceService = invoiceService;
        this.customerService = customerService;
        this.addressService = addressService;
    }

    public FileWriter getWriter(String typeOfFile) {
        if (Strings.isNullOrEmpty(typeOfFile)) {
            return null;
        } else if (typeOfFile.equalsIgnoreCase(ConstMessagesEN.Buttons.CSV_RADIO_BUTTON)) {
            return new my.projects.invoiceapplication.application.writer.CsvWriter();
        } else if (typeOfFile.equalsIgnoreCase(ConstMessagesEN.Buttons.EXCEL_RADIO_BUTTON)) {
            return new my.projects.invoiceapplication.application.writer.XlsWriter();
        } else if (typeOfFile.equalsIgnoreCase(ConstMessagesEN.Buttons.XML_RADIO_BUTTON)) {
            return new my.projects.invoiceapplication.application.writer.XmlWriter();
        }

        return null;
    }

    public List getEntities(String typeOfEntities) {
        List entities = null;

        if (typeOfEntities.equalsIgnoreCase(ConstMessagesEN.FrameNames.INVOICE)) {
            entities = invoiceService.findAll();
        } else if (typeOfEntities.equalsIgnoreCase(ConstMessagesEN.FrameNames.CUSTOMER)) {
            entities = customerService.findAll();
        } else if (typeOfEntities.equalsIgnoreCase(ConstMessagesEN.FrameNames.ADDRESS)) {
            entities = addressService.findAll();
        }

        return entities;
    }

    public Path getPath(Object entity, String typeOfFile) {
        String pathString = "src/main/resources/file/";
        String fileType = "";

        if (typeOfFile.equalsIgnoreCase(ConstMessagesEN.Buttons.CSV_RADIO_BUTTON)) {
            fileType = "csv";
        } else if (typeOfFile.equalsIgnoreCase(ConstMessagesEN.Buttons.EXCEL_RADIO_BUTTON)) {
            fileType = "xlsx";
        } else if (typeOfFile.equalsIgnoreCase(ConstMessagesEN.Buttons.XML_RADIO_BUTTON)) {
            fileType = "xml";
        }

        pathString += fileType;

        if (entity instanceof Invoice) pathString += "/invoices.";
        else if (entity instanceof Customer) pathString += "/customers.";
        else if (entity instanceof Address) pathString += "/addresses.";

        pathString += fileType;

        return Paths.get(pathString);
    }

    public static String[] getHeader(Object entity) {
        if (entity instanceof Invoice) {
            return new String[] { "invoice number", "invoice name", "value", "currency", "vat",
                "customer name", "pesel", "phone number", "customer address" };
        } else if (entity instanceof Customer) {
            return new String[] { "first name",  "surname", "pesel", "phone number",  "customer address" };
        } else if (entity instanceof Address) {
            return new String[] { "city", "street", "house number", "local number", "postal code" };
        }

        return null;
    }
}
