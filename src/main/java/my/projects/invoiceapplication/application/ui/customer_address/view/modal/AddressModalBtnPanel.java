package my.projects.invoiceapplication.application.ui.customer_address.view.modal;

import my.projects.invoiceapplication.application.util.ConstMessagesEN;
import org.springframework.stereotype.Component;

import javax.swing.*;

@Component
public class AddressModalBtnPanel extends JPanel {

    private JButton saveBtn;
    private JButton cancelBtn;

    public AddressModalBtnPanel() {
        initComponents();
    }

    private void initComponents() {
        saveBtn = new JButton(ConstMessagesEN.Buttons.SAVE_BUTTON);
        add(saveBtn);

        cancelBtn = new JButton(ConstMessagesEN.Buttons.CANCEL_BUTTON);
        add(cancelBtn);
    }

    public JButton getSaveBtn() {
        return saveBtn;
    }

    public JButton getCancelBtn() {
        return cancelBtn;
    }
}
