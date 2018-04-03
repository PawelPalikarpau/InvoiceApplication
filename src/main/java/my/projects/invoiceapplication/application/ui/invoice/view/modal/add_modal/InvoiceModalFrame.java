package my.projects.invoiceapplication.application.ui.invoice.view.modal.add_modal;

import my.projects.invoiceapplication.application.util.ConstMessagesEN;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

@Component
public class InvoiceModalFrame extends JDialog {

    private static final int WIDTH = 500;
    private static final int HEIGHT = 350;

    private InvoiceModalPanel invoiceModalPanel;
    private InvoiceModalBtnPanel invoiceModalBtnPanel;

    @Autowired
    public InvoiceModalFrame(InvoiceModalPanel invoiceModalPanel, InvoiceModalBtnPanel invoiceModalBtnPanel) {
        this.invoiceModalPanel = invoiceModalPanel;
        this.invoiceModalBtnPanel = invoiceModalBtnPanel;
        setFrameUp();
        initComponents();
    }

    private void setFrameUp() {
        setTitle(ConstMessagesEN.FrameNames.INVOICE_MODAL);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        setResizable(false);
        setModal(true);
    }

    private void initComponents() {
        add(invoiceModalPanel, BorderLayout.CENTER);
        add(invoiceModalBtnPanel, BorderLayout.SOUTH);
    }

    public InvoiceModalPanel getModalPanel() {
        return invoiceModalPanel;
    }

    public InvoiceModalBtnPanel getModalBtnPanel() {
        return invoiceModalBtnPanel;
    }
}
