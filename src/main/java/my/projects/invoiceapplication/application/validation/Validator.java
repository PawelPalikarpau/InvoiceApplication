package my.projects.invoiceapplication.application.validation;

import java.util.Optional;

public interface Validator <K> {
    Optional<ValidationError> validate(K k);
}
