package my.projects.invoiceapplication.application.entity;

import javax.persistence.*;

@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue
    @Column(name = "address_id")
    private long id;

    @Column(name = "city")
    private String city;

    @Column(name = "street")
    private String street;

    @Column(name = "house_number")
    private String houseNumber;

    @Column(name = "local_number")
    private String localNumber;

    @Column(name = "postal_code")
    private String postalCode;

    public Address() {
    }

    public Address(String city, String street, String houseNumber, String localNumber, String postalCode) {
        this.city = city;
        this.street = street;
        this.houseNumber = houseNumber;
        this.localNumber = localNumber;
        this.postalCode = postalCode;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getLocalNumber() {
        return localNumber;
    }

    public void setLocalNumber(String localNumber) {
        this.localNumber = localNumber;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Address that = (Address) o;

        if (id != that.id) return false;
        if (city != null ? !city.equals(that.city) : that.city != null) return false;
        if (street != null ? !street.equals(that.street) : that.street != null) return false;
        if (houseNumber != null ? !houseNumber.equals(that.houseNumber) : that.houseNumber != null) return false;
        if (localNumber != null ? !localNumber.equals(that.localNumber) : that.localNumber != null) return false;
        return postalCode != null ? postalCode.equals(that.postalCode) : that.postalCode == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (street != null ? street.hashCode() : 0);
        result = 31 * result + (houseNumber != null ? houseNumber.hashCode() : 0);
        result = 31 * result + (localNumber != null ? localNumber.hashCode() : 0);
        result = 31 * result + (postalCode != null ? postalCode.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return street + " " +
                houseNumber + "/" +
                localNumber + ", " +
                postalCode + " " +
                city;
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
        return new String[] { city, street, houseNumber, localNumber, postalCode };
    }
}
