package my.projects.invoiceapplication.application.util;

public interface ConstMessagesEN {

    interface FrameNames {
        String MAIN_MENU = "Main Menu";
        String WRITE_MODAL = "Write To File";
        String INVOICE = "Invoices";
        String INVOICE_MODAL = "Add Invoice";
        String CUSTOMER = "Customers";
        String CUSTOMER_MODAL = "Add Customer";
        String ADDRESS = "Customer Addresses";
        String ADDRESS_MODAL = "Add Address";
    }

    interface Labels {

        interface Invoice {
            String NUMBER_LABEL = "Invoice Number:";
            String NAME_LABEL = "Invoice Name:";
            String CUSTOMER_LABEL = "Customer:";
            String VALUE_LABEL = "Value:";
            String CURRENCY_LABEL = "Currency:";
            String VAT_LABEL = "Vat, %:";
        }

        interface CustomerAddress {
            String CITY_LABEL = "City:";
            String STREET_LABEL = "Street:";
            String HOUSE_NUMBER_LABEL = "House Number:";
            String LOCAL_NUMBER_LABEL = "Local Number:";
            String POSTAL_CODE_LABEL = "Postal Code:";
        }

        interface Customer {
            String FIRST_NAME_LABEL = "First Name:";
            String SURNAME_LABEL = "Surname:";
            String PESEL_LABEL = "Pesel:";
            String PHONE_NUMBER_LABEL = "Phone Number:";
            String CUSTOMER_ADDRESS_LABEL = "Customer Adderss:";
        }

        String CHOOSE_FILE_TYPE = "Choose the file type to write";
    }

    interface Tables {

        interface Address {
            String CITY = "City";
            String STREET = "Street";
            String HOUSE_NUMBER = "House Number";
            String LOCAL_NUMBER = "Local Number";
            String POSTAL_CODE = "Postal Code";
        }

        interface Invoice {
            String NUMBER = "Number";
            String INVOICE_NAME = "Invoice Name";
            String CUSTOMER_NAME = "Customer Name";
            String VALUE = "Value";
            String CURRENCY = "Currency";
            String VAT = "Vat, %";
        }

        interface Customer {
            String FIRST_NAME = "First Name";
            String SURNAME = "Surname";
            String PESEL = "Pesel";
            String PHONE_NUMBER = "Phone Number";
            String ADDRESS = "Address";
        }
    }

    interface Buttons {
        String ADD_BUTTON = "Add";
        String SAVE_BUTTON = "Save";
        String REMOVE_BUTTON = "Remove";
        String CANCEL_BUTTON = "Cancel";
        String WRITE_BUTTON = "Write to File";
        String INVOICES = "Invoices";
        String CUSTOMERS = "Customers";
        String ADDRESSES = "Addresses";

        String EXCEL_RADIO_BUTTON = "Excel";
        String CSV_RADIO_BUTTON = "CSV";
        String XML_RADIO_BUTTON = "XML";
    }

    interface Message {
        String ALERT = "Alert";
        String NON_ROW_MESSAGE = "Non row has been selected";
        String DELETE_ROW_MESSAGE = "Could not delete a row. Check if there are any connections between tables.";
        String VALIDATION_ERROR_MESSAGE = "Not all required fields have been filled or filled data is incorrect";
        String CAN_NOT_CREATE_FILE = "There is a problem with creating a file";
        String CAN_NOT_WRITE_TO_FILE = "There is a problem with writing to a file";
        String NO_DATA_TO_WRITE = "There is no data to write from this table";
        String CAN_NOT_CLOSE_BUFFER_WRITER = "Can't close buffer writer";
    }
}
