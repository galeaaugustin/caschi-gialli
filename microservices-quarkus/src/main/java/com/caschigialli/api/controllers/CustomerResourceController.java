package com.caschigialli.api.controllers;

import com.caschigialli.api.models.Customer;
import com.caschigialli.api.records.Message;
import com.caschigialli.api.repositories.CustomerRepository;
import com.caschigialli.api.services.UserService;
import io.quarkus.security.identity.SecurityIdentity;
import io.vertx.ext.web.RequestBody;
import jakarta.annotation.security.RolesAllowed;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.Optional;

@Path("/api/customer")
public class CustomerResourceController {

    private final UserService userService;
    private final SecurityIdentity securityIdentity;
    private final CustomerRepository customerRepository;

    public CustomerResourceController(UserService userService,
                                      SecurityIdentity securityIdentity,
                                      CustomerRepository customerRepository) {
        this.userService = userService;
        this.securityIdentity = securityIdentity;
        this.customerRepository = customerRepository;
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed({"VIEW_CUSTOMER_DETAILS"})
    public Iterable<Customer> findAllCustomers() {
        return customerRepository.findAll();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Customer getCustomerById(Long id) {
        Optional<Customer> optional = customerRepository.findById(id);
        if (optional.isPresent()) {
            Customer customer = optional.get();
            return customer;
        }
        throw new IllegalArgumentException("No Customer with id " + id + " exists");
    }

    @GET
    @Path("/user-name/{userName}")
    @Produces(MediaType.APPLICATION_JSON)
    public Iterable<Customer> getCustomerByUserName(String userName) {
        return customerRepository.findByUserName(userName);
    }


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response createCustomer(Customer customer) {
        customerRepository.save(customer);
        return Response.status(Response.Status.CREATED).build();
    }


    @PUT
    @Path("/{id}")
    public Response updateCustomer(@PathParam("id") Long id, Customer customer) {
        Optional<Customer> optional = customerRepository.findById(id);
        if (optional.isPresent()) {
            Customer entity = optional.get();

            customerRepository.save(entity);
            return Response.ok().build();

        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }


    @DELETE
    @Path("{id}")
    public void delete(long id) {
        customerRepository.deleteById(id);
    }
}
