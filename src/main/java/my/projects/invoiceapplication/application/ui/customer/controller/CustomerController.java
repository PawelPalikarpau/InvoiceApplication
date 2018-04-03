package my.projects.invoiceapplication.application.ui.customer.controller;

import my.projects.invoiceapplication.application.entity.Address;
import my.projects.invoiceapplication.application.entity.Customer;
import my.projects.invoiceapplication.application.service.AddressService;
import my.projects.invoiceapplication.application.service.CustomerService;
import my.projects.invoiceapplication.application.ui.customer.model.AddressComboBoxModel;
import my.projects.invoiceapplication.application.ui.customer.model.CustomerTableModel;
import my.projects.invoiceapplication.application.ui.customer.view.CustomerFrame;
import my.projects.invoiceapplication.application.ui.customer.view.CustomerTableBtnPanel;
import my.projects.invoiceapplication.application.ui.customer.view.modal.CustomerModalBtnPanel;
import my.projects.invoiceapplication.application.ui.customer.view.modal.CustomerModalFrame;
import my.projects.invoiceapplication.application.ui.customer.view.modal.CustomerModalPanel;
import my.projects.invoiceapplication.application.ui.shared.controller.AbstractFrameController;
import my.projects.invoiceapplication.application.ui.write.controller.WriteController;
import my.projects.invoiceapplication.application.util.ConstMessagesEN;
import my.projects.invoiceapplication.application.util.Notifications;
import my.projects.invoiceapplication.application.validation.CustomerValidator;
import my.projects.invoiceapplication.application.validation.ValidationError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.util.List;
import java.util.Optional;

@Controller
public class CustomerController extends AbstractFrameController {

    private CustomerFrame customerFrame;
    private WriteController writeController;
    private CustomerModalFrame customerModalFrame;
    private CustomerService customerService;
    private AddressService addressService;
    private CustomerTableModel customerTableModel;
    private AddressComboBoxModel addressComboBoxModel;
    private CustomerValidator validator;

    @Autowired
    public CustomerController(CustomerFrame customerFrame,
                              WriteController writeController,
                              CustomerModalFrame customerModalFrame,
                              CustomerService customerService,
                              AddressService addressService,
                              CustomerTableModel customerTableModel,
                              AddressComboBoxModel addressComboBoxModel,
                              CustomerValidator validator) {
        this.customerFrame = customerFrame;
        this.writeController = writeController;
        this.customerModalFrame = customerModalFrame;
        this.customerService = customerService;
        this.addressService = addressService;
        this.customerTableModel = customerTableModel;
        this.addressComboBoxModel = addressComboBoxModel;
        this.validator = validator;
    }

    @Override
    public void prepareAndOpenFrame() {
        loadEntities();
        loadAddresses();
        showFrame();
    }

    @PostConstruct
    private void prepareListeners() {
        CustomerTableBtnPanel btnPanel = customerFrame.getBtnPanel();
        CustomerModalBtnPanel modalBtnPanel = customerModalFrame.getModalBtnPanel();

        registerAction(btnPanel.getWriteBtn(), (e) -> openWriteFrame());
        registerAction(btnPanel.getAddBtn(), (e) -> showAddModal());
        registerAction(btnPanel.getRemoveBtn(), (e) -> removeEntity());
        registerAction(modalBtnPanel.getSaveBtn(), (e) -> saveEntity());
        registerAction(modalBtnPanel.getCancelBtn(), (e) -> closeModalFrame());
    }

    private void showFrame() {
        customerFrame.setVisible(true);
    }

    private void showAddModal() {
        customerModalFrame.setVisible(true);
    }

    private void closeModalFrame() {
        customerModalFrame.getModalPanel().clear();
        customerModalFrame.dispose();
    }

    private void openWriteFrame() {
        writeController.setTypeOfEntities(ConstMessagesEN.FrameNames.CUSTOMER);
        writeController.prepareAndOpenFrame();
    }

    private void loadEntities() {
        List<Customer> entities = customerService.findAll();
        customerTableModel.clear();
        customerTableModel.addEntities(entities);
    }

    private void loadAddresses() {
        List<Address> addresses = addressService.findAll();
        addressComboBoxModel.clear();
        addressComboBoxModel.addElements(addresses);
    }

    private void saveEntity() {
        CustomerModalPanel modalPanel = customerModalFrame.getModalPanel();
        Customer entity = modalPanel.getEntityFromModal();
        Optional<ValidationError> errors = validator.validate(entity);
        if (errors.isPresent()) {
            ValidationError validationError = errors.get();
            Notifications.showValidationErrorMessage(validationError.getMessage());
        } else {
            customerService.save(entity);
            customerTableModel.addEntity(entity);
            closeModalFrame();
        }
    }

    private void removeEntity() {
        try {
            JTable customerTable = customerFrame.getTablePanel().getTable();
            int selectedRow = customerTable.getSelectedRow();
            if (selectedRow < 0) {
                Notifications.showNonRowSelectedErrorMessage();
            } else {
                Customer customer = customerTableModel.getEntityByRow(selectedRow);
                customerService.remove(customer);
                customerTableModel.removeRow(selectedRow);
            }
        } catch (Exception e) {
            Notifications.showDeleteRowErrorMessage();
        }
    }
}
