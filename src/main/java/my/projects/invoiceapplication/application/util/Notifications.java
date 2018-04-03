package my.projects.invoiceapplication.application.util;

import javax.swing.*;

public class Notifications {

    public static void showValidationErrorMessage(String message) {
        JOptionPane.showMessageDialog(null,
                message,
                ConstMessagesEN.Message.ALERT,
                JOptionPane.ERROR_MESSAGE);
    }

    public static void showNonRowSelectedErrorMessage() {
        JOptionPane.showMessageDialog(null,
                ConstMessagesEN.Message.NON_ROW_MESSAGE,
                ConstMessagesEN.Message.ALERT,
                JOptionPane.ERROR_MESSAGE);
    }

    public static void showDeleteRowErrorMessage() {
        JOptionPane.showMessageDialog(null,
                ConstMessagesEN.Message.DELETE_ROW_MESSAGE,
                ConstMessagesEN.Message.ALERT,
                JOptionPane.ERROR_MESSAGE);
    }

    public static void showCanNotCreateFileErrorMessage() {
        JOptionPane.showMessageDialog(null,
                ConstMessagesEN.Message.CAN_NOT_CREATE_FILE,
                ConstMessagesEN.Message.ALERT,
                JOptionPane.ERROR_MESSAGE);
    }

    public static void showCanNotWriteToFileErrorMessage() {
        JOptionPane.showMessageDialog(null,
                ConstMessagesEN.Message.CAN_NOT_WRITE_TO_FILE,
                ConstMessagesEN.Message.ALERT,
                JOptionPane.ERROR_MESSAGE);
    }

    public static void showNoDataToWriteErrorMessage() {
        JOptionPane.showMessageDialog(null,
                ConstMessagesEN.Message.NO_DATA_TO_WRITE,
                ConstMessagesEN.Message.ALERT,
                JOptionPane.ERROR_MESSAGE);
    }

    public static void showCanNotCloseBufferWriterErrorMessage() {
        JOptionPane.showMessageDialog(null,
                ConstMessagesEN.Message.CAN_NOT_CLOSE_BUFFER_WRITER,
                ConstMessagesEN.Message.ALERT,
                JOptionPane.ERROR_MESSAGE);
    }
}
