package my.projects.invoiceapplication.application.ui.write.controller;

import my.projects.invoiceapplication.application.ui.shared.controller.AbstractFrameController;
import my.projects.invoiceapplication.application.ui.write.view.WriteBtnPanel;
import my.projects.invoiceapplication.application.ui.write.view.WriteFrame;
import my.projects.invoiceapplication.application.ui.write.view.WritePanel;
import my.projects.invoiceapplication.application.util.Notifications;
import my.projects.invoiceapplication.application.util.WriterFactory;
import my.projects.invoiceapplication.application.writer.FileWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedList;
import java.util.List;

@Controller
public class WriteController extends AbstractFrameController {

    private WriteFrame writeFrame;
    private final WriterFactory writerFactory;
    private static String typeOfEntities;

    @Autowired
    public WriteController(WriteFrame writeFrame, WriterFactory writerFactory) {
        this.writeFrame = writeFrame;
        this.writerFactory = writerFactory;
    }

    @Override
    public void prepareAndOpenFrame() {
        showFrame();
    }

    @PostConstruct
    private void prepareListeners() {
        WriteBtnPanel writeBtnPanel = writeFrame.getWriteBtnPanel();

        registerAction(writeBtnPanel.getWriteBtn(), (e) -> writeToFile());
        registerAction(writeBtnPanel.getCancelBtn(), (e) -> closeWriteModalFrame());
    }

    private void showFrame() {
        writeFrame.setVisible(true);
    }

    private void closeWriteModalFrame() {
        writeFrame.getWritePanel().clear();
        writeFrame.dispose();
    }

    private void writeToFile() {
        WritePanel modalPanel = writeFrame.getWritePanel();

        FileWriter writer = writerFactory.getWriter(modalPanel.getFileTypeFromModal());
        List entities = new LinkedList(writerFactory.getEntities(typeOfEntities));
        Path path = writerFactory.getPath(entities.get(0), modalPanel.getFileTypeFromModal());

        if (!entities.isEmpty()){
            File file = new File(path.toString());
            if (!file.exists() && !file.isDirectory()) {
                try {
                    Files.createFile(path);
                } catch (IOException ignored) {
                    Notifications.showCanNotCreateFileErrorMessage();
                }
            }
            writer.write(entities, path);
        } else {
            Notifications.showNoDataToWriteErrorMessage();
        }

        writeFrame.getWritePanel().clear();
        writeFrame.dispose();
    }

    public static void setTypeOfEntities(String typeOfEntities) {
        WriteController.typeOfEntities = typeOfEntities;
    }
}
