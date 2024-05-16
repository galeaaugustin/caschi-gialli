package com.caschigialli.api.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Address {
    @Column(name = "street", table = "address")
    public String street;

    @Column(name = "city", table = "address")
    public String city;

    @Column(name = "state", table = "address")
    public String state;

    @Column(name = "postal_code", table = "address")
    public String postalCode;

    @Column(name = "longitude", table = "address")
    public String longitude;

    @Column(name = "latitude", table = "address")
    public String latitude;
}
