package my.projects.invoiceapplication.application.ui.customer.model;

import my.projects.invoiceapplication.application.entity.Customer;
import my.projects.invoiceapplication.application.ui.shared.model.DefaultTableModel;
import my.projects.invoiceapplication.application.util.ConstMessagesEN;
import org.springframework.stereotype.Component;

@Component
public class CustomerTableModel extends DefaultTableModel<Customer> {

    @Override
    public String[] getColumnLabels() {
        return new String[] {
                ConstMessagesEN.Tables.Customer.FIRST_NAME,
                ConstMessagesEN.Tables.Customer.SURNAME,
                ConstMessagesEN.Tables.Customer.PESEL,
                ConstMessagesEN.Tables.Customer.PHONE_NUMBER,
                ConstMessagesEN.Tables.Customer.ADDRESS
        };
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Customer customer = entities.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return customer.getFirstName();
            case 1:
                return customer.getSurname();
            case 2:
                return customer.getPesel();
            case 3:
                return customer.getPhoneNumber();
            case 4:
                return customer.getAddress().toString();
            default:
                return "";
        }
    }
}
