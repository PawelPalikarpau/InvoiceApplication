package my.projects.invoiceapplication.application.ui.customer.view.modal;

import my.projects.invoiceapplication.application.entity.Address;
import my.projects.invoiceapplication.application.entity.Customer;
import my.projects.invoiceapplication.application.service.AddressService;
import my.projects.invoiceapplication.application.ui.customer.model.AddressComboBoxModel;
import my.projects.invoiceapplication.application.util.Borders;
import my.projects.invoiceapplication.application.util.ConstMessagesEN;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

@Component
public class CustomerModalPanel extends JPanel {

    private AddressComboBoxModel addressComboBoxModel;
    private AddressService addressService;

    private static final int LAYOUT_ROWS = 5;
    private static final int LAYOUT_COLS = 2;
    private static final int HORIZONTAL_GAP = 0;
    private static final int VERTICAL_GAP = 20;
    private static final int TEXT_FIELD_COLUMNS = 20;

    private JComboBox<Address> addressCB;
    private JTextField firstNameTF;
    private JTextField surnameTF;
    private JTextField peselTF;
    private JTextField phoneNumberTF;

    @Autowired
    public CustomerModalPanel(AddressComboBoxModel addressComboBoxModel, AddressService addressService) {
        this.addressComboBoxModel = addressComboBoxModel;
        this.addressService = addressService;
        setPanelUp();
        initComponents();
    }

    private void setPanelUp() {
        setBorder(Borders.createEmptyBorder());;
        setLayout(new GridLayout(LAYOUT_ROWS, LAYOUT_COLS, HORIZONTAL_GAP, VERTICAL_GAP));
    }

    private void initComponents() {
        JLabel addressLabel = new JLabel(ConstMessagesEN.Labels.Customer.CUSTOMER_ADDRESS_LABEL);
        JLabel firstNameLabel = new JLabel(ConstMessagesEN.Labels.Customer.FIRST_NAME_LABEL);
        JLabel surnameLabel = new JLabel(ConstMessagesEN.Labels.Customer.SURNAME_LABEL);
        JLabel peselLabel = new JLabel(ConstMessagesEN.Labels.Customer.PESEL_LABEL);
        JLabel phoneNumberLabel = new JLabel(ConstMessagesEN.Labels.Customer.PHONE_NUMBER_LABEL);

        addressCB = new JComboBox<>(addressComboBoxModel);
        firstNameTF = new JTextField(TEXT_FIELD_COLUMNS);
        surnameTF = new JTextField(TEXT_FIELD_COLUMNS);
        peselTF = new JTextField(TEXT_FIELD_COLUMNS);
        phoneNumberTF = new JTextField(TEXT_FIELD_COLUMNS);

        add(addressLabel);
        add(addressCB);
        add(firstNameLabel);
        add(firstNameTF);
        add(surnameLabel);
        add(surnameTF);
        add(peselLabel);
        add(peselTF);
        add(phoneNumberLabel);
        add(phoneNumberTF);
    }

    public Customer getEntityFromModal() {
        Customer customer = new Customer();
        customer.setAddress((Address) addressCB.getSelectedItem());
        customer.setFirstName(firstNameTF.getText());
        customer.setSurname(surnameTF.getText());
        customer.setPesel(peselTF.getText());
        customer.setPhoneNumber(phoneNumberTF.getText());
        addressService.remove(customer.getAddress());
        customer.getAddress().setId(0);
        return customer;
    }

    public void clear() {
        firstNameTF.setText("");
        surnameTF.setText("");
        peselTF.setText("");
        phoneNumberTF.setText("");
    }
}
