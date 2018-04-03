package my.projects.invoiceapplication.application.ui.invoice.view;

import my.projects.invoiceapplication.application.ui.invoice.model.InvoiceTableModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

@Component
public class InvoiceTablePanel extends JTable {

    private InvoiceTableModel invoiceTableModel;

    private JTable invoiceTable;

    @Autowired
    public InvoiceTablePanel(InvoiceTableModel invoiceTableModel) {
        this.invoiceTableModel = invoiceTableModel;
        setPanelUp();
        initComponents();
    }

    private void setPanelUp() {
        setLayout(new BorderLayout());
    }

    private void initComponents() {
        invoiceTable = new JTable(invoiceTableModel);
        invoiceTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane paneWithTable = new JScrollPane(invoiceTable);
        add(paneWithTable, BorderLayout.CENTER);
    }

    public JTable getTable() {
        return invoiceTable;
    }
}
