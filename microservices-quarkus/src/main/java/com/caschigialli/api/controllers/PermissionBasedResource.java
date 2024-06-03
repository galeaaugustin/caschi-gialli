package com.caschigialli.api.controllers;

import com.caschigialli.api.records.Message;
import io.quarkus.security.PermissionsAllowed;
import io.quarkus.security.identity.SecurityIdentity;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/permission-based")
public class PermissionBasedResource {

    private final SecurityIdentity securityIdentity;

    public PermissionBasedResource(final SecurityIdentity securityIdentity) {
        this.securityIdentity = securityIdentity;
    }

    @GET
    @Path("/resource/version")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @PermissionsAllowed("VIEW_ADMIN_DETAILS")
    public String get() {
        return "2.0.0";
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/resource/message")
    @PermissionsAllowed(value = {"SEND_MESSAGE", "OPERATOR"}, inclusive = true)
    public Message message() {
        return new Message("Hello "+securityIdentity.getPrincipal().getName()+"!");
    }
}