package my.projects.invoiceapplication.application.ui.write.view;

import my.projects.invoiceapplication.application.util.ConstMessagesEN;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

@Component
public class WriteFrame extends JDialog {

    private static final int WIDTH = 250;
    private static final int HEIGHT = 120;

    private WritePanel writePanel;
    private WriteBtnPanel writeBtnPanel;

    @Autowired
    public WriteFrame(WritePanel writePanel, WriteBtnPanel writeBtnPanel) {
        this.writePanel = writePanel;
        this.writeBtnPanel = writeBtnPanel;
        setFrameUp();
        initComponent();
    }

    private void setFrameUp() {
        setTitle(ConstMessagesEN.FrameNames.WRITE_MODAL);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        setResizable(false);
        setModal(true);
    }

    private void initComponent() {
        add(writePanel, BorderLayout.CENTER);
        add(writeBtnPanel, BorderLayout.SOUTH);
    }

    public WritePanel getWritePanel() {
        return writePanel;
    }

    public WriteBtnPanel getWriteBtnPanel() {
        return writeBtnPanel;
    }
}
