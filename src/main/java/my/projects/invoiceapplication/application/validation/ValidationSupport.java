package my.projects.invoiceapplication.application.validation;

import org.assertj.core.util.Strings;

public abstract class ValidationSupport {

    boolean isNullOrEmptyString(String string) {
        return Strings.isNullOrEmpty(string);
    }

    boolean isNullValue(Object value) {
        return value == null;
    }

}
