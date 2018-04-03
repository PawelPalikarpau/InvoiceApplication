package my.projects.invoiceapplication.application.validation;

import my.projects.invoiceapplication.application.entity.Address;
import my.projects.invoiceapplication.application.util.ConstMessagesEN;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AddressValidator extends ValidationSupport implements Validator<Address> {
    @Override
    public Optional<ValidationError> validate(Address address) {
        if (isNullOrEmptyString(address.getCity()) ||
                isNullOrEmptyString(address.getStreet()) ||
                isNullOrEmptyString(address.getHouseNumber()) ||
                isNullOrEmptyString(address.getLocalNumber()) ||
                isNullOrEmptyString(address.getPostalCode())) {
            return Optional.of(new ValidationError(ConstMessagesEN.Message.VALIDATION_ERROR_MESSAGE));
        }
        return Optional.empty();
    }
}
