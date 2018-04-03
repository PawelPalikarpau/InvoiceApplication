package my.projects.invoiceapplication.application.ui.customer_address.view.modal;

import my.projects.invoiceapplication.application.entity.Address;
import my.projects.invoiceapplication.application.util.Borders;
import my.projects.invoiceapplication.application.util.ConstMessagesEN;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

@Component
public class AddressModalPanel extends JPanel {

    private static final int LAYOUT_ROWS = 5;
    private static final int LAYOUT_COLS = 2;
    private static final int HORIZONTAL_GAP = 0;
    private static final int VERTICAL_GAP = 20;
    private static final int TEXT_FIELD_COLUMNS = 20;

    private JTextField cityTF;
    private JTextField streetTF;
    private JTextField houseNumberTF;
    private JTextField localNumberTF;
    private JTextField postalCodeTF;

    public AddressModalPanel() {
        setPanelUp();
        initComponents();
    }

    private void setPanelUp() {
        setBorder(Borders.createEmptyBorder());
        setLayout(new GridLayout(LAYOUT_ROWS, LAYOUT_COLS, HORIZONTAL_GAP, VERTICAL_GAP));
    }

    private void initComponents() {
        JLabel cityLabel = new JLabel(ConstMessagesEN.Labels.CustomerAddress.CITY_LABEL);
        JLabel streetLabel = new JLabel(ConstMessagesEN.Labels.CustomerAddress.STREET_LABEL);
        JLabel houseNumberLabel = new JLabel(ConstMessagesEN.Labels.CustomerAddress.HOUSE_NUMBER_LABEL);
        JLabel localNumberLabel = new JLabel(ConstMessagesEN.Labels.CustomerAddress.LOCAL_NUMBER_LABEL);
        JLabel postalCodeLabel = new JLabel(ConstMessagesEN.Labels.CustomerAddress.POSTAL_CODE_LABEL);

        cityTF = new JTextField(TEXT_FIELD_COLUMNS);
        streetTF = new JTextField(TEXT_FIELD_COLUMNS);
        houseNumberTF = new JTextField(TEXT_FIELD_COLUMNS);
        localNumberTF = new JTextField(TEXT_FIELD_COLUMNS);
        postalCodeTF = new JTextField(TEXT_FIELD_COLUMNS);

        add(cityLabel);
        add(cityTF);
        add(streetLabel);
        add(streetTF);
        add(houseNumberLabel);
        add(houseNumberTF);
        add(localNumberLabel);
        add(localNumberTF);
        add(postalCodeLabel);
        add(postalCodeTF);
    }

    public Address getEntityFromModal() {
        Address address = new Address();
        address.setCity(cityTF.getText());
        address.setStreet(streetTF.getText());
        address.setHouseNumber(houseNumberTF.getText());
        address.setLocalNumber(localNumberTF.getText());
        address.setPostalCode(postalCodeTF.getText());
        return address;
    }

    public void clearModal() {
        cityTF.setText("");
        streetTF.setText("");
        houseNumberTF.setText("");
        localNumberTF.setText("");
        postalCodeTF.setText("");
    }
}
