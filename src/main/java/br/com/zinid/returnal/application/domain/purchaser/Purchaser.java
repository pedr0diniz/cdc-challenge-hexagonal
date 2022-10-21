package br.com.zinid.returnal.application.domain.purchaser;

public class Purchaser {

    private String email;
    private String name;
    private String surname;
    private String document;
    private Address address;
    private String phoneNumber;

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getDocument() {
        return document;
    }

    public Address getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Purchaser(String email, String name, String surname, String document, Address address, String phoneNumber) {
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.document = document;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }
}
