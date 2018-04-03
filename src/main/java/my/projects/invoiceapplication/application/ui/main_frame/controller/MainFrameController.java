package my.projects.invoiceapplication.application.ui.main_frame.controller;

import my.projects.invoiceapplication.application.entity.Address;
import my.projects.invoiceapplication.application.entity.Customer;
import my.projects.invoiceapplication.application.entity.Invoice;
import my.projects.invoiceapplication.application.repository.InvoiceRepository;
import my.projects.invoiceapplication.application.ui.customer.controller.CustomerController;
import my.projects.invoiceapplication.application.ui.customer_address.controller.AddressController;
import my.projects.invoiceapplication.application.ui.invoice.controller.InvoiceController;
import my.projects.invoiceapplication.application.ui.main_frame.view.MainFrame;
import my.projects.invoiceapplication.application.ui.shared.controller.AbstractFrameController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MainFrameController extends AbstractFrameController {

    private MainFrame mainFrame;
    private CustomerController customerController;
    private AddressController addressController;
    private InvoiceController invoiceController;

    private InvoiceRepository invoiceRepository;

    @Autowired
    public MainFrameController(MainFrame mainFrame,
                               CustomerController customerController,
                               AddressController addressController,
                               InvoiceController invoiceController,
                               InvoiceRepository invoiceRepository) {
        this.mainFrame = mainFrame;
        this.customerController = customerController;
        this.addressController = addressController;
        this.invoiceController = invoiceController;
        this.invoiceRepository = invoiceRepository;
    }

    public void prepareAndOpenFrame() {
        if (invoiceRepository.count() == 0) fillDefaultValuesToDatabase();

        registerAction(mainFrame.getCustomerBtn(), (e) -> openCustomerForm());
        registerAction(mainFrame.getInvoiceBtn(), (e) -> openInvoiceForm());
        registerAction(mainFrame.getAddressBtn(), (e) -> openAddressForm());
        mainFrame.setVisible(true);
    }

    private void openCustomerForm() { customerController.prepareAndOpenFrame(); }

    private void openInvoiceForm() { invoiceController.prepareAndOpenFrame(); }

    private void openAddressForm() { addressController.prepareAndOpenFrame(); }

    private void fillDefaultValuesToDatabase() {
        Address firstAddress = new Address("Poznan", "Strzalkowskiego", "15", "7", "60-854");
        Customer firstCustomer = new Customer("John", "Smith", "93070819661", "732334211", firstAddress);
        Invoice firstInvoice = new Invoice("1", "Mobile Phone", firstCustomer, 15.07, "PLN", 8);

        Address secondAddress = new Address("Warszawa", "Zlota", "31", "2", "60-000");
        Customer secondCustomer = new Customer("Marry", "Jobs", "12345678990", "567567567", secondAddress);
        Invoice secondInvoice = new Invoice("2", "Window Glass", secondCustomer, 145.11, "PLN", 23);

        Address thirdAddress = new Address("Wroclaw", "Grunwaldzka", "147A", "6B", "60-111");
        Customer thirdCustomer = new Customer("Bob", "Popins", "56565678901", "123123123", thirdAddress);
        Invoice thirdInvoice = new Invoice("3", "TV", thirdCustomer, 1145.11, "EUR", 23);

        invoiceRepository.save(firstInvoice);
        invoiceRepository.save(secondInvoice);
        invoiceRepository.save(thirdInvoice);
    }
}
