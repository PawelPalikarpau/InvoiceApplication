package my.projects.invoiceapplication.application.ui.customer_address.view;

import my.projects.invoiceapplication.application.ui.customer_address.model.AddressTableModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

@Component
public class AddressTablePanel extends JTable {

    private AddressTableModel addressTableModel;

    private JTable addressTable;

    @Autowired
    public AddressTablePanel(AddressTableModel addressTableModel) {
        this.addressTableModel = addressTableModel;
        setPanelUp();
        initComponents();
    }

    private void setPanelUp() {
        setLayout(new BorderLayout());
    }

    private void initComponents() {
        addressTable = new JTable(addressTableModel);
        addressTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane paneWithTable = new JScrollPane(addressTable);
        add(paneWithTable, BorderLayout.CENTER);
    }

    public JTable getTable() {
        return addressTable;
    }

}
