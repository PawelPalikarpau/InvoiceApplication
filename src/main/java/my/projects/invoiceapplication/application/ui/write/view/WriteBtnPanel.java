package my.projects.invoiceapplication.application.ui.write.view;

import my.projects.invoiceapplication.application.util.ConstMessagesEN;
import org.springframework.stereotype.Component;

import javax.swing.*;

@Component
public class WriteBtnPanel extends JPanel {

    private JButton writeBtn;
    private JButton cancelBtn;

    public WriteBtnPanel() {
        initComponents();
    }

    private void initComponents() {
        writeBtn = new JButton(ConstMessagesEN.Buttons.WRITE_BUTTON);
        add(writeBtn);

        cancelBtn = new JButton(ConstMessagesEN.Buttons.CANCEL_BUTTON);
        add(cancelBtn);
    }

    public JButton getWriteBtn() {
        return writeBtn;
    }

    public JButton getCancelBtn() {
        return cancelBtn;
    }
}
