package com.caschigialli.api.models;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@SecondaryTable(name = "address", pkJoinColumns = @PrimaryKeyJoinColumn(name = "address_id"))
public class Customer extends PanacheEntity {

    @Column( name = "user_id")
    public Long userId;

    @NotBlank(message = "First name is mandatory")
    @Column( name = "first_name")
    public String firstName;

    @NotBlank(message = "Last name is mandatory")
    @Column ( name = "last_name")
    public String lastName;

    @NotBlank(message = "User name is mandatory")
    @Column ( name = "user_name")
    public String userName;

    @Column ( name = "pass")
    public String password;

    @Column ( name = "active_token")
    public String activeToken;

    @Column ( name = "customer_type")
    public String customerType;

    @NotBlank(message = "Customer email is mandatory")
    @Column ( name = "email")
    public String email;

    @NotBlank(message = "Customer phone is mandatory to send SMS")
    @Column ( name = "phone_number")
    public String phoneNumber;

    @Column ( name = "is_company")
    public String isCompany;

    @Column ( name = "company_name")
    public String companyName;

    @Embedded
    Address address;
}
