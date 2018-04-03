package my.projects.invoiceapplication.application.ui.customer.view.modal;

import my.projects.invoiceapplication.application.util.ConstMessagesEN;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

@Component
public class CustomerModalFrame extends JDialog {

    private static final int WIDTH = 400;
    private static final int HEIGHT = 300;

    private CustomerModalPanel customerModalPanel;
    private CustomerModalBtnPanel customerModalBtnPanel;

    @Autowired
    public CustomerModalFrame(CustomerModalPanel customerModalPanel, CustomerModalBtnPanel customerModalBtnPanel) {
        this.customerModalPanel = customerModalPanel;
        this.customerModalBtnPanel = customerModalBtnPanel;
        setFrameUp();
        initComponents();
    }

    private void setFrameUp() {
        setTitle(ConstMessagesEN.FrameNames.CUSTOMER_MODAL);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        setResizable(false);
        setModal(true);
    }

    private void initComponents() {
        add(customerModalPanel, BorderLayout.CENTER);
        add(customerModalBtnPanel, BorderLayout.SOUTH);
    }

    public CustomerModalPanel getModalPanel() {
        return customerModalPanel;
    }

    public CustomerModalBtnPanel getModalBtnPanel() {
        return customerModalBtnPanel;
    }
}
