package my.projects.invoiceapplication.application.ui.invoice.controller;

import my.projects.invoiceapplication.application.entity.Customer;
import my.projects.invoiceapplication.application.entity.Invoice;
import my.projects.invoiceapplication.application.service.CustomerService;
import my.projects.invoiceapplication.application.service.InvoiceService;
import my.projects.invoiceapplication.application.ui.invoice.model.CustomerComboBoxModel;
import my.projects.invoiceapplication.application.ui.invoice.model.InvoiceTableModel;
import my.projects.invoiceapplication.application.ui.invoice.view.InvoiceFrame;
import my.projects.invoiceapplication.application.ui.invoice.view.InvoiceTableBtnPanel;
import my.projects.invoiceapplication.application.ui.invoice.view.modal.add_modal.InvoiceModalBtnPanel;
import my.projects.invoiceapplication.application.ui.invoice.view.modal.add_modal.InvoiceModalFrame;
import my.projects.invoiceapplication.application.ui.invoice.view.modal.add_modal.InvoiceModalPanel;
import my.projects.invoiceapplication.application.ui.shared.controller.AbstractFrameController;
import my.projects.invoiceapplication.application.ui.write.controller.WriteController;
import my.projects.invoiceapplication.application.ui.write.view.WriteFrame;
import my.projects.invoiceapplication.application.util.ConstMessagesEN;
import my.projects.invoiceapplication.application.util.Notifications;
import my.projects.invoiceapplication.application.validation.InvoiceValidator;
import my.projects.invoiceapplication.application.validation.ValidationError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.util.List;
import java.util.Optional;

@Controller
public class InvoiceController extends AbstractFrameController {

    private InvoiceFrame invoiceFrame;
    private InvoiceModalFrame invoiceModalFrame;
    private WriteFrame writeFrame;
    private WriteController writeController;
    private InvoiceService invoiceService;
    private CustomerService customerService;
    private InvoiceTableModel invoiceTableModel;
    private CustomerComboBoxModel customerComboBoxModel;
    private InvoiceValidator validator;

    @Autowired
    public InvoiceController(InvoiceFrame invoiceFrame,
                             InvoiceModalFrame invoiceModalFrame,
                             WriteFrame writeFrame,
                             WriteController writeController,
                             InvoiceService invoiceService,
                             CustomerService customerService,
                             InvoiceTableModel invoiceTableModel,
                             CustomerComboBoxModel customerComboBoxModel,
                             InvoiceValidator validator) {
        this.invoiceFrame = invoiceFrame;
        this.invoiceModalFrame = invoiceModalFrame;
        this.writeFrame = writeFrame;
        this.writeController = writeController;
        this.invoiceService = invoiceService;
        this.customerService = customerService;
        this.invoiceTableModel = invoiceTableModel;
        this.customerComboBoxModel = customerComboBoxModel;
        this.validator = validator;
    }

    @Override
    public void prepareAndOpenFrame() {
        loadEntities();
        loadCustomers();
        showFrame();
    }

    @PostConstruct
    private void prepareListeners() {
        InvoiceTableBtnPanel btnPanel = invoiceFrame.getBtnPanel();
        InvoiceModalBtnPanel modalBtnPanel = invoiceModalFrame.getModalBtnPanel();

        registerAction(btnPanel.getWriteBtn(), (e) -> openWriteFrame());
        registerAction(btnPanel.getAddBtn(), (e) -> showAddFrame());
        registerAction(btnPanel.getRemoveBtn(), (e) -> removeEntity());
        registerAction(modalBtnPanel.getSaveBtn(), (e) -> saveEntity());
        registerAction(modalBtnPanel.getCancelBtn(), (e) -> closeModalFrame());
    }

    private void loadEntities() {
        List<Invoice> entities = invoiceService.findAll();
        invoiceTableModel.clear();
        invoiceTableModel.addEntities(entities);
    }

    private void loadCustomers() {
        List<Customer> customers = customerService.findAll();
        customerComboBoxModel.clear();
        customerComboBoxModel.addElements(customers);
    }

    private void showFrame() {
        invoiceFrame.setVisible(true);
    }

    private void showAddFrame() {
        invoiceModalFrame.setVisible(true);
    }

    private void closeModalFrame() {
        invoiceModalFrame.getModalPanel().clear();
        invoiceModalFrame.dispose();
    }

    private void openWriteFrame() {
        writeController.setTypeOfEntities(ConstMessagesEN.FrameNames.INVOICE);
        writeController.prepareAndOpenFrame();
    }

    private void saveEntity() {
        InvoiceModalPanel modalPanel = invoiceModalFrame.getModalPanel();
        Invoice entity = modalPanel.getEntityFromModal();
        Optional<ValidationError> errors = validator.validate(entity);
        if (errors.isPresent()) {
            ValidationError validationError = errors.get();
            Notifications.showValidationErrorMessage(validationError.getMessage());
        } else {
            invoiceService.save(entity);
            invoiceTableModel.addEntity(entity);
            closeModalFrame();
        }
    }

    private void removeEntity() {
        try{
            JTable invoiceTable = invoiceFrame.getTablePanel().getTable();
            int selectedRow = invoiceTable.getSelectedRow();
            if (selectedRow < 0) {
                Notifications.showNonRowSelectedErrorMessage();
            } else {
                Invoice invoice = invoiceTableModel.getEntityByRow(selectedRow);
                invoiceService.remove(invoice);
                invoiceTableModel.removeRow(selectedRow);
            }
        } catch (Exception e) {
            Notifications.showDeleteRowErrorMessage();
        }
    }
}
