package my.projects.invoiceapplication.application.ui.invoice.view.modal.add_modal;

import my.projects.invoiceapplication.application.entity.Customer;
import my.projects.invoiceapplication.application.entity.Invoice;
import my.projects.invoiceapplication.application.service.CustomerService;
import my.projects.invoiceapplication.application.ui.invoice.model.CustomerComboBoxModel;
import my.projects.invoiceapplication.application.util.Borders;
import my.projects.invoiceapplication.application.util.ConstMessagesEN;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

@Component
public class InvoiceModalPanel extends JPanel {

    private CustomerComboBoxModel customerComboBoxModel;
    private CustomerService customerService;

    private static final int LAYOUT_ROWS = 6;
    private static final int LAYOUT_COLS = 2;
    private static final int HORIZONTAL_GAP = 0;
    private static final int VERTICAL_GAP = 20;
    private static final int TEXT_FIELD_COLUMNS = 20;

    private JTextField numberTX;
    private JTextField nameTX;
    private JComboBox<Customer> customerCB;
    private JTextField valueTF;
    private JTextField currencyTF;
    private JTextField vatTF;


    @Autowired
    public InvoiceModalPanel(CustomerComboBoxModel customerComboBoxModel, CustomerService customerService) {
        this.customerComboBoxModel = customerComboBoxModel;
        this.customerService = customerService;
        setPanelUp();
        initComponents();
    }

    private void setPanelUp() {
        setBorder(Borders.createEmptyBorder());
        setLayout(new GridLayout(LAYOUT_ROWS, LAYOUT_COLS, HORIZONTAL_GAP, VERTICAL_GAP));
    }

    private void initComponents() {
        JLabel numberLabel = new JLabel(ConstMessagesEN.Labels.Invoice.NUMBER_LABEL);
        JLabel nameLabel = new JLabel(ConstMessagesEN.Labels.Invoice.NAME_LABEL);
        JLabel customerLabel = new JLabel(ConstMessagesEN.Labels.Invoice.CUSTOMER_LABEL);
        JLabel valueLabel = new JLabel(ConstMessagesEN.Labels.Invoice.VALUE_LABEL);
        JLabel currencyLabel = new JLabel(ConstMessagesEN.Labels.Invoice.CURRENCY_LABEL);
        JLabel vatLabel = new JLabel(ConstMessagesEN.Labels.Invoice.VAT_LABEL);

        numberTX = new JTextField(TEXT_FIELD_COLUMNS);
        nameTX = new JTextField(TEXT_FIELD_COLUMNS);
        customerCB = new JComboBox<>(customerComboBoxModel);
        valueTF = new JTextField(TEXT_FIELD_COLUMNS);
        currencyTF = new JTextField(TEXT_FIELD_COLUMNS);
        vatTF = new JTextField(TEXT_FIELD_COLUMNS);

        add(numberLabel);
        add(numberTX);
        add(nameLabel);
        add(nameTX);
        add(customerLabel);
        add(customerCB);
        add(valueLabel);
        add(valueTF);
        add(currencyLabel);
        add(currencyTF);
        add(vatLabel);
        add(vatTF);
    }

    public Invoice getEntityFromModal() {
        Invoice invoice = new Invoice();
        invoice.setNumber(numberTX.getText());
        invoice.setName(nameTX.getText());
        invoice.setCustomer((Customer) customerCB.getSelectedItem());
        try {
            invoice.setValue(Long.parseLong(valueTF.getText()));
        } catch (NumberFormatException ignored) {}
        invoice.setCurrency(currencyTF.getText());
        try {
            invoice.setVat(Integer.parseInt(vatTF.getText()));
        } catch (NumberFormatException ignored) {}
        return invoice;
    }

    public void clear() {
        numberTX.setText("");
        nameTX.setText("");
        valueTF.setText("");;
        currencyTF.setText("");
        valueTF.setText("");
    }
}
