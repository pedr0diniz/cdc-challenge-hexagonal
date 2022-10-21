package br.com.zinid.returnal.adapter.purchaser.input;

import br.com.zinid.returnal.adapter.country.output.CountryEntity;
import br.com.zinid.returnal.adapter.purchaser.output.PurchaserEntity;
import br.com.zinid.returnal.adapter.state.output.StateEntity;
import br.com.zinid.returnal.application.domain.purchaser.Address;
import br.com.zinid.returnal.application.domain.purchaser.Purchaser;
import br.com.zinid.returnal.application.config.validation.CPFOrCNPJ;
import br.com.zinid.returnal.application.config.validation.IdMustExist;
import br.com.zinid.returnal.application.config.validation.MandatoryStateWhenApplicable;
import br.com.zinid.returnal.application.config.validation.UniqueField;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@MandatoryStateWhenApplicable
public class PurchaserRequest {

    @NotBlank @Email
    private String email;

    @NotBlank
    private String name;

    @NotBlank
    private String surname;

    @NotBlank @CPFOrCNPJ @UniqueField(fieldName = "document", entityClass = PurchaserEntity.class)
    private String document;

    @NotBlank
    private String addressOne;

    @NotBlank
    private String addressTwo;

    @NotBlank
    private String city;

    @NotNull @IdMustExist(entityClass = CountryEntity.class)
    private Long countryId;

    @IdMustExist(entityClass = StateEntity.class)
    private Long stateId;

    @NotBlank
    private String phoneNumber;

    @NotBlank
    private String zipCode;

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

    public String getAddressOne() {
        return addressOne;
    }

    public String getAddressTwo() {
        return addressTwo;
    }

    public String getCity() {
        return city;
    }

    public Long getCountryId() {
        return countryId;
    }

    public Long getStateId() {
        return stateId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getZipCode() {
        return zipCode;
    }

    public PurchaserRequest(String email, String name, String surname, String document, String addressOne,
                            String addressTwo, String city, Long countryId, Long stateId, String phoneNumber,
                            String zipCode) {
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.document = document;
        this.addressOne = addressOne;
        this.addressTwo = addressTwo;
        this.city = city;
        this.countryId = countryId;
        this.stateId = stateId;
        this.phoneNumber = phoneNumber;
        this.zipCode = zipCode;
    }

    public Purchaser toDomain() {
        return new Purchaser(
                email = email,
                name = name,
                surname = surname,
                document = document,
                new Address(
                        addressOne = addressOne,
                        addressTwo = addressTwo,
                        city = city,
                        countryId = countryId,
                        stateId = stateId,
                        zipCode = zipCode
                ),
                phoneNumber = phoneNumber
        );
    }
}
