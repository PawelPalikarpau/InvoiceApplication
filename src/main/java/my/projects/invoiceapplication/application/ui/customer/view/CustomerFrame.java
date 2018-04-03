package my.projects.invoiceapplication.application.ui.customer.view;

import my.projects.invoiceapplication.application.util.ConstMessagesEN;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

@Component
public class CustomerFrame extends JFrame {

    private static final int WIDTH = 1200;
    private static final int HEIGHT = 200;

    private CustomerTablePanel customerTablePanel;
    private CustomerTableBtnPanel customerTableBtnPanel;

    @Autowired
    public CustomerFrame(CustomerTablePanel customerTablePanel, CustomerTableBtnPanel customerTableBtnPanel) {
        this.customerTablePanel = customerTablePanel;
        this.customerTableBtnPanel = customerTableBtnPanel;
        setFrameUp();
        initComponents();
    }

    private void setFrameUp() {
        setTitle(ConstMessagesEN.FrameNames.CUSTOMER);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void initComponents() {
        add(customerTablePanel, BorderLayout.CENTER);
        add(customerTableBtnPanel, BorderLayout.SOUTH);
    }

    public CustomerTablePanel getTablePanel() {
        return customerTablePanel;
    }

    public CustomerTableBtnPanel getBtnPanel() {
        return customerTableBtnPanel;
    }
}
