package my.projects.invoiceapplication.application.ui.main_frame.view;

import my.projects.invoiceapplication.application.util.Borders;
import my.projects.invoiceapplication.application.util.ConstMessagesEN;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

@Component
public class MainFrame extends JFrame {

    private static final int WIDTH = 500;
    private static final int HEIGHT = 110;

    private JButton invoiceBtn;
    private JButton customerBtn;
    private JButton addressBtn;

    @Autowired
    public MainFrame() {
        setFrameUp();
        initComponents();
    }

    private void setFrameUp() {
        getRootPane().setBorder(Borders.createEmptyBorder());
        setTitle(ConstMessagesEN.FrameNames.MAIN_MENU);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(new GridLayout(1, 3, 30, 30));
    }

    private void initComponents() {
        invoiceBtn = new JButton(ConstMessagesEN.Buttons.INVOICES);
        customerBtn = new JButton(ConstMessagesEN.Buttons.CUSTOMERS);
        addressBtn = new JButton(ConstMessagesEN.Buttons.ADDRESSES);

        add(invoiceBtn);
        add(customerBtn);
        add(addressBtn);
    }

    public JButton getInvoiceBtn() {
        return invoiceBtn;
    }

    public JButton getCustomerBtn() {
        return customerBtn;
    }

    public JButton getAddressBtn() {
        return addressBtn;
    }
}
