package my.projects.invoiceapplication.application.ui.invoice.view;

import my.projects.invoiceapplication.application.util.ConstMessagesEN;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

@Component
public class InvoiceFrame extends JFrame {

    private static final int WIDTH = 700;
    private static final int HEIGHT = 200;

    private InvoiceTablePanel invoiceTablePanel;
    private InvoiceTableBtnPanel invoiceTableBtnPanel;

    @Autowired
    public InvoiceFrame(InvoiceTablePanel invoiceTablePanel, InvoiceTableBtnPanel invoiceTableBtnPanel) {
        this.invoiceTablePanel = invoiceTablePanel;
        this.invoiceTableBtnPanel = invoiceTableBtnPanel;
        setFrameUp();
        initComponents();
    }

    private void setFrameUp() {
        setTitle(ConstMessagesEN.FrameNames.INVOICE);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void initComponents() {
        add(invoiceTablePanel, BorderLayout.CENTER);
        add(invoiceTableBtnPanel, BorderLayout.SOUTH);
    }

    public InvoiceTablePanel getTablePanel() {
        return invoiceTablePanel;
    }

    public InvoiceTableBtnPanel getBtnPanel() {
        return invoiceTableBtnPanel;
    }
}
