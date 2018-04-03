package my.projects.invoiceapplication.application.ui.customer_address.view;

import my.projects.invoiceapplication.application.util.ConstMessagesEN;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

@Component
public class AddressFrame extends JFrame {

    private static final int WIDTH = 700;
    private static final int HEIGHT = 200;

    private AddressTablePanel addressTablePanel;
    private AddressTableBtnPanel addressTableBtnPanel;

    @Autowired
    public AddressFrame(AddressTablePanel addressTablePanel, AddressTableBtnPanel addressTableBtnPanel) {
        this.addressTablePanel = addressTablePanel;
        this.addressTableBtnPanel = addressTableBtnPanel;
        setFrameUp();
        initComponents();
    }

    private void setFrameUp() {
        setTitle(ConstMessagesEN.FrameNames.ADDRESS);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void initComponents() {
        add(addressTablePanel, BorderLayout.CENTER);
        add(addressTableBtnPanel, BorderLayout.SOUTH);
    }

    public AddressTablePanel getTablePanel() {
        return addressTablePanel;
    }

    public AddressTableBtnPanel getBtnPanel() {
        return addressTableBtnPanel;
    }
}
