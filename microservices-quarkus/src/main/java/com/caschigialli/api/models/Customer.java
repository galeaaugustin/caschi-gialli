package com.caschigialli.api.models;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;

@Entity
@SecondaryTable(name = "address", pkJoinColumns = @PrimaryKeyJoinColumn(name = "address_id"))
public class Customer extends PanacheEntity {

    @Column( name = "user_id")
    public Long userId;

    @Column( name = "first_name")
    public String firstName;

    @Column ( name = "last_name")
    public String lastName;

    @Column ( name = "user_name")
    public String userName;

    @Column ( name = "pass")
    public String password;

    @Column ( name = "active_token")
    public String activeToken;

    @Column ( name = "customer_type")
    public String customerType;

    @Column ( name = "email")
    public String email;

    @Column ( name = "phone_number")
    public String phoneNumber;

    @Column ( name = "is_company")
    public String isCompany;

    @Column ( name = "company_name")
    public String companyName;

    @Embedded
    Address address;
}
