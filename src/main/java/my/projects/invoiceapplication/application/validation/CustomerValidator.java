package my.projects.invoiceapplication.application.validation;

import my.projects.invoiceapplication.application.entity.Customer;
import my.projects.invoiceapplication.application.util.ConstMessagesEN;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CustomerValidator extends ValidationSupport implements Validator<Customer> {

    @Override
    public Optional<ValidationError> validate(Customer customer) {
        if (isNullOrEmptyString(customer.getFirstName()) ||
                isNullOrEmptyString(customer.getSurname()) ||
                isNullOrEmptyString(customer.getPesel()) ||
                isNullOrEmptyString(customer.getPhoneNumber()) ||
                isNullValue(customer.getAddress())) {
            return Optional.of(new ValidationError(ConstMessagesEN.Message.VALIDATION_ERROR_MESSAGE));
        }
        return Optional.empty();
    }
}
