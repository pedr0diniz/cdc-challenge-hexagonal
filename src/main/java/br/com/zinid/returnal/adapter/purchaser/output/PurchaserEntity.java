package br.com.zinid.returnal.adapter.purchaser.output;

import br.com.zinid.returnal.adapter.country.output.CountryEntity;
import br.com.zinid.returnal.adapter.state.output.StateEntity;
import br.com.zinid.returnal.application.domain.purchaser.Purchaser;

import javax.persistence.*;

@Entity(name = "purchaser")
public class PurchaserEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String name;
    private String surname;
    private String document;
    private String addressOne;
    private String addressTwo;
    private String city;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private CountryEntity countryEntity;

    @ManyToOne
    @JoinColumn(name = "state_id")
    private StateEntity stateEntity;

    private String zipCode;
    private String phoneNumber;

    public Long getId() {
        return id;
    }

    public PurchaserEntity() {
    }

    public PurchaserEntity(Long id) {
        this.id = id;
    }

    public PurchaserEntity(Purchaser purchaser) {
        if (purchaser.getAddress().getStateId() != null) {
            this.stateEntity = new StateEntity(purchaser.getAddress().getStateId());
        }

        this.email = purchaser.getEmail();
        this.name = purchaser.getName();
        this.surname = purchaser.getSurname();
        this.document = purchaser.getDocument();
        this.addressOne = purchaser.getAddress().getAddressOne();
        this.addressTwo = purchaser.getAddress().getAddressTwo();
        this.city = purchaser.getAddress().getCity();
        this.countryEntity = new CountryEntity(purchaser.getAddress().getCountryId());
        this.phoneNumber = purchaser.getPhoneNumber();
        this.zipCode = purchaser.getAddress().getZipCode();
    }
}
