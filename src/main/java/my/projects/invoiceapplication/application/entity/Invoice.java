package my.projects.invoiceapplication.application.entity;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Entity
@Table(name = "invoice")
public class Invoice {

    @Id
    @GeneratedValue
    @Column(name = "invoice_id")
    private long id;

    @Column(name = "number")
    private String number;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Column(name = "value", nullable = false)
    private double value;

    @Column(name = "currency", nullable = false)
    private String currency;

    @Column(name = "vat", nullable = false)
    private int vat;

    public Invoice() {
    }

    public Invoice(String number, String name, Customer customer, double value, String currency, int vat) {
        this.number = number;
        this.name = name;
        this.customer = customer;
        this.value = value;
        this.currency = currency;
        this.vat = vat;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public int getVat() {
        return vat;
    }

    public void setVat(int vat) {
        this.vat = vat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Invoice invoice = (Invoice) o;

        if (id != invoice.id) return false;
        if (Double.compare(invoice.value, value) != 0) return false;
        if (vat != invoice.vat) return false;
        if (number != null ? !number.equals(invoice.number) : invoice.number != null) return false;
        if (name != null ? !name.equals(invoice.name) : invoice.name != null) return false;
        if (customer != null ? !customer.equals(invoice.customer) : invoice.customer != null) return false;
        return currency != null ? currency.equals(invoice.currency) : invoice.currency == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) (id ^ (id >>> 32));
        result = 31 * result + (number != null ? number.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (customer != null ? customer.hashCode() : 0);
        temp = Double.doubleToLongBits(value);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (currency != null ? currency.hashCode() : 0);
        result = 31 * result + vat;
        return result;
    }

    public StringBuilder toCsv() {
        StringBuilder builder = new StringBuilder();

        String[] strings = toStringArray();
        for (int i = 0; i < strings.length; i++) {
            if (i < strings.length - 1)
                builder.append("\"").append(strings[i]).append("\",");
            else
                builder.append("\"").append(strings[i]).append("\"\r\n");
        }

        return builder;
    }

    public String[] toStringArray() {
        return new String[] { number, name, Double.toString(value), currency, Integer.toString(vat),
                customer.getFirstName() + " " + customer.getSurname(), customer.getPesel(),
                customer.getPhoneNumber(), customer.getAddress().toString() };
    }
}
