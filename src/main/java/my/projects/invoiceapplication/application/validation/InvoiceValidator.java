package my.projects.invoiceapplication.application.validation;

import my.projects.invoiceapplication.application.entity.Invoice;
import my.projects.invoiceapplication.application.util.ConstMessagesEN;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class InvoiceValidator extends ValidationSupport implements Validator<Invoice> {

    @Override
    public Optional<ValidationError> validate(Invoice invoice) {
        if (isNullOrEmptyString(invoice.getNumber()) ||
                isNullOrEmptyString(invoice.getName()) ||
                isNullValue(invoice.getValue()) ||
                isNullOrEmptyString(invoice.getCurrency()) ||
                isNullValue(invoice.getVat()) ||
                isNullValue(invoice.getCustomer())) {
            return Optional.of(new ValidationError(ConstMessagesEN.Message.VALIDATION_ERROR_MESSAGE));
        }
        return Optional.empty();
    }
}
