package my.projects.invoiceapplication.application.ui.customer_address.model;

import my.projects.invoiceapplication.application.entity.Address;
import my.projects.invoiceapplication.application.ui.shared.model.DefaultTableModel;
import my.projects.invoiceapplication.application.util.ConstMessagesEN;
import org.springframework.stereotype.Component;

@Component
public class AddressTableModel extends DefaultTableModel<Address> {

    @Override
    public String[] getColumnLabels() {
        return new String[] {
                ConstMessagesEN.Tables.Address.CITY,
                ConstMessagesEN.Tables.Address.STREET,
                ConstMessagesEN.Tables.Address.HOUSE_NUMBER,
                ConstMessagesEN.Tables.Address.LOCAL_NUMBER,
                ConstMessagesEN.Tables.Address.POSTAL_CODE
        };
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Address address = entities.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return address.getCity();
            case 1:
                return address.getStreet();
            case 2:
                return address.getHouseNumber();
            case 3:
                return address.getLocalNumber();
            case 4:
                return address.getPostalCode();
            default:
                return "";
        }
    }
}
