package pl.SeleniumDemo.models;

public class Customer {

    private String firstName = "Jan";
    private String lastName = "Kowalski";
    private String companyName = "Random Company";
    private String streetAddressHouseNumber;
    private String streetAddressApartment;
    private String postcode = "11-222";
    private String city = "Random City";
    private String phoneNumber = "123123123";
    private String emailAddres = "randomEmail@email.com.pl";
    private String country = "Poland";

    private String street = "Random Street";
    private String flatNumber = "123";

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getFlatNumber() {
        return flatNumber;
    }

    public void setFlatNumber(String flatNumber) {
        this.flatNumber = flatNumber;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getStreetAddressHouseNumber() {
        return streetAddressHouseNumber;
    }

    public void setStreetAddressHouseNumber(String streetAddressHouseNumber) {
        this.streetAddressHouseNumber = streetAddressHouseNumber;
    }

    public String getStreetAddressApartment() {
        return streetAddressApartment;
    }

    public void setStreetAddressApartment(String streetAddressApartment) {
        this.streetAddressApartment = streetAddressApartment;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddres() {
        return emailAddres;
    }

    public void setEmailAddres(String emailAddres) {
        this.emailAddres = emailAddres;
    }
}
