package my.projects.invoiceapplication.application.ui.customer_address.view.modal;

import my.projects.invoiceapplication.application.util.ConstMessagesEN;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

@Component
public class AddressModalFrame extends JDialog {

    private static final int WIDTH = 400;
    private static final int HEIGHT = 300;

    private AddressModalPanel addressModalPanel;
    private AddressModalBtnPanel addressModalBtnPanel;

    @Autowired
    public AddressModalFrame(AddressModalPanel addressModalPanel, AddressModalBtnPanel addressModalBtnPanel) {
        this.addressModalPanel = addressModalPanel;
        this.addressModalBtnPanel = addressModalBtnPanel;
        setFrameUp();
        initComponents();
    }

    private void setFrameUp() {
        setTitle(ConstMessagesEN.FrameNames.ADDRESS_MODAL);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        setResizable(true);
        setModal(true);
    }

    private void initComponents() {
        add(addressModalPanel, BorderLayout.CENTER);
        add(addressModalBtnPanel, BorderLayout.SOUTH);
    }

    public AddressModalPanel getModalPanel() {
        return addressModalPanel;
    }

    public AddressModalBtnPanel getModalBtnPanel() {
        return addressModalBtnPanel;
    }
}
