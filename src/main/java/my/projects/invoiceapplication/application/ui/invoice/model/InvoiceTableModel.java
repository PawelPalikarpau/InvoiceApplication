package my.projects.invoiceapplication.application.ui.invoice.model;

import my.projects.invoiceapplication.application.entity.Invoice;
import my.projects.invoiceapplication.application.ui.shared.model.DefaultTableModel;
import my.projects.invoiceapplication.application.util.ConstMessagesEN;
import org.springframework.stereotype.Component;

@Component
public class InvoiceTableModel extends DefaultTableModel<Invoice> {

    @Override
    public String[] getColumnLabels() {
        return new String[]{
                ConstMessagesEN.Tables.Invoice.NUMBER,
                ConstMessagesEN.Tables.Invoice.INVOICE_NAME,
                ConstMessagesEN.Tables.Invoice.CUSTOMER_NAME,
                ConstMessagesEN.Tables.Invoice.VALUE,
                ConstMessagesEN.Tables.Invoice.CURRENCY,
                ConstMessagesEN.Tables.Invoice.VAT
        };
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Invoice invoice = entities.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return invoice.getNumber();
            case 1:
                return invoice.getName();
            case 2:
                return invoice.getCustomer().getFirstName() + " " + invoice.getCustomer().getSurname();
            case 3:
                return invoice.getValue();
            case 4:
                return invoice.getCurrency();
            case 5:
                return invoice.getVat();
            default:
                return "";
        }
    }
}
