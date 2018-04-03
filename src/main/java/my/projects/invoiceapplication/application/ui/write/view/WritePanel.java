package my.projects.invoiceapplication.application.ui.write.view;

import my.projects.invoiceapplication.application.util.Borders;
import my.projects.invoiceapplication.application.util.ConstMessagesEN;
import org.springframework.stereotype.Component;

import javax.swing.*;

@Component
public class WritePanel extends JPanel {

    private JRadioButton excelRB;
    private JRadioButton csvRB;
    private JRadioButton xmlRB;

    public WritePanel() {
        setPanelUp();
        initComponents();
    }

    private void setPanelUp() {
        setBorder(Borders.createTitledBorder(ConstMessagesEN.Labels.CHOOSE_FILE_TYPE));
    }

    private void initComponents() {
        excelRB = new JRadioButton(ConstMessagesEN.Buttons.EXCEL_RADIO_BUTTON);
        csvRB= new JRadioButton(ConstMessagesEN.Buttons.CSV_RADIO_BUTTON);
        xmlRB = new JRadioButton(ConstMessagesEN.Buttons.XML_RADIO_BUTTON);

        ButtonGroup fileFormatGroup = new ButtonGroup();

        fileFormatGroup.add(excelRB);
        fileFormatGroup.add(csvRB);
        fileFormatGroup.add(xmlRB);

        add(excelRB);
        add(csvRB);
        add(xmlRB);

        excelRB.setSelected(true);
    }

    public String getFileTypeFromModal() {
        if (excelRB.isSelected()) return ConstMessagesEN.Buttons.EXCEL_RADIO_BUTTON;
        if (csvRB.isSelected()) return ConstMessagesEN.Buttons.CSV_RADIO_BUTTON;
        if (xmlRB.isSelected()) return ConstMessagesEN.Buttons.XML_RADIO_BUTTON;
        return "";
    }

    public void clear() {
        excelRB.setSelected(true);
    }
}
