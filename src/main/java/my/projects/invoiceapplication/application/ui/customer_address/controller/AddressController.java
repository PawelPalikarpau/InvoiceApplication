package my.projects.invoiceapplication.application.ui.customer_address.controller;

import my.projects.invoiceapplication.application.entity.Address;
import my.projects.invoiceapplication.application.service.AddressService;
import my.projects.invoiceapplication.application.ui.customer_address.model.AddressTableModel;
import my.projects.invoiceapplication.application.ui.customer_address.view.AddressFrame;
import my.projects.invoiceapplication.application.ui.customer_address.view.AddressTableBtnPanel;
import my.projects.invoiceapplication.application.ui.customer_address.view.modal.AddressModalBtnPanel;
import my.projects.invoiceapplication.application.ui.customer_address.view.modal.AddressModalFrame;
import my.projects.invoiceapplication.application.ui.customer_address.view.modal.AddressModalPanel;
import my.projects.invoiceapplication.application.ui.shared.controller.AbstractFrameController;
import my.projects.invoiceapplication.application.ui.write.controller.WriteController;
import my.projects.invoiceapplication.application.util.ConstMessagesEN;
import my.projects.invoiceapplication.application.util.Notifications;
import my.projects.invoiceapplication.application.validation.AddressValidator;
import my.projects.invoiceapplication.application.validation.ValidationError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import javax.swing.*;
import java.util.List;
import java.util.Optional;

@Controller
public class AddressController extends AbstractFrameController {

    private AddressFrame addressFrame;
    private WriteController writeController;
    private AddressService addressService;
    private AddressTableModel addressTableModel;
    private AddressModalFrame addressModalFrame;
    private AddressValidator validator;

    @Autowired
    public AddressController(AddressFrame addressFrame,
                             WriteController writeController,
                             AddressService addressService,
                             AddressTableModel addressTableModel,
                             AddressModalFrame addressModalFrame,
                             AddressValidator validator) {
        this.addressFrame = addressFrame;
        this.writeController = writeController;
        this.addressService = addressService;
        this.addressTableModel = addressTableModel;
        this.addressModalFrame = addressModalFrame;
        this.validator = validator;
    }

    @PostConstruct
    private void prepareListeners() {
        AddressTableBtnPanel btnPanel = addressFrame.getBtnPanel();
        AddressModalBtnPanel modalBtnPanel = addressModalFrame.getModalBtnPanel();

        registerAction(btnPanel.getWriteBtn(), (e) -> openWriteFrame());
        registerAction(btnPanel.getAddBtn(), (e) -> showAddModal());
        registerAction(btnPanel.getRemoveBtn(), (e) -> removeEntity());
        registerAction(modalBtnPanel.getSaveBtn(), (e) -> saveEntity());
        registerAction(modalBtnPanel.getCancelBtn(), (e) -> closeModalFrame());
    }

    @Override
    public void prepareAndOpenFrame() {
        loadEntities();
        showFrame();
    }

    private void showFrame() {
        addressFrame.setVisible(true);
    }

    private void showAddModal() {
        addressModalFrame.setVisible(true);
    }

    private void closeModalFrame() {
        addressModalFrame.getModalPanel().clearModal();
        addressModalFrame.dispose();
    }

    private void openWriteFrame() {
        writeController.setTypeOfEntities(ConstMessagesEN.FrameNames.ADDRESS);
        writeController.prepareAndOpenFrame();
    }

    private void loadEntities() {
        List<Address> addresses = addressService.findAll();
        addressTableModel.clear();
        addressTableModel.addEntities(addresses);
    }

    private void saveEntity() {
        AddressModalPanel modalPanel = addressModalFrame.getModalPanel();
        Address entity = modalPanel.getEntityFromModal();
        Optional<ValidationError> errors = validator.validate(entity);
        if (errors.isPresent()) {
            ValidationError validationError = errors.get();
            Notifications.showValidationErrorMessage(validationError.getMessage());
        } else {
            addressService.save(entity);
            addressTableModel.addEntity(entity);
            closeModalFrame();
        }
    }

    private void removeEntity() {
        try {
            JTable addressTable = addressFrame.getTablePanel().getTable();
            int selectedRow = addressTable.getSelectedRow();
            if (selectedRow < 0) {
                Notifications.showNonRowSelectedErrorMessage();
            } else {
                Address entity = addressTableModel.getEntityByRow(selectedRow);
                addressService.remove(entity);
                addressTableModel.removeRow(selectedRow);
            }
        } catch (Exception e) {
            Notifications.showDeleteRowErrorMessage();
        }
    }
}
