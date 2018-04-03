package my.projects.invoiceapplication.application.ui.customer.view;

import my.projects.invoiceapplication.application.ui.customer.model.CustomerTableModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

@Component
public class CustomerTablePanel extends JTable {

    private CustomerTableModel customerTableModel;

    private JTable customerTable;

    @Autowired
    public CustomerTablePanel(CustomerTableModel customerTableModel) {
        this.customerTableModel = customerTableModel;
        setPanelUp();
        initComponents();
    }

    private void setPanelUp() {
        setLayout(new BorderLayout());
    }

    private void initComponents() {
        customerTable = new JTable(customerTableModel);
        customerTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane paneWithTable= new JScrollPane(customerTable);
        add(paneWithTable, BorderLayout.CENTER);
    }

    public JTable getTable() {
        return customerTable;
    }
}
