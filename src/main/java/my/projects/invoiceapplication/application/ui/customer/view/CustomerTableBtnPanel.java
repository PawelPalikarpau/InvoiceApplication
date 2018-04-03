package my.projects.invoiceapplication.application.ui.customer.view;

import my.projects.invoiceapplication.application.util.ConstMessagesEN;
import org.springframework.stereotype.Component;

import javax.swing.*;

@Component
public class CustomerTableBtnPanel extends JPanel {

    private JButton writeBtn;
    private JButton addBtn;
    private JButton removeBtn;

    public CustomerTableBtnPanel() {
        initComponents();
    }

    private void initComponents() {
        writeBtn = new JButton(ConstMessagesEN.Buttons.WRITE_BUTTON);
        add(writeBtn);

        addBtn = new JButton(ConstMessagesEN.Buttons.ADD_BUTTON);
        add(addBtn);

        removeBtn= new JButton(ConstMessagesEN.Buttons.REMOVE_BUTTON);
        add(removeBtn);
    }

    public JButton getWriteBtn() {
        return writeBtn;
    }

    public JButton getAddBtn() {
        return addBtn;
    }

    public JButton getRemoveBtn() {
        return removeBtn;
    }
}
