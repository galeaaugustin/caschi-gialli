package com.caschigialli.api.controllers;

import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;


import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@Path("/")
@Tag(name = "root")
public class GreetingResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Operation(summary = "Get root", description = "Return root")
    @APIResponses(value = {//
            @APIResponse(responseCode = "200", description = "OK", content = @Content(mediaType = APPLICATION_JSON,
                    schema = @Schema(type = SchemaType.OBJECT))),
            @APIResponse(responseCode = "409", description = "application errors",
                    content = @Content(mediaType = APPLICATION_JSON,
                            schema = @Schema(type = SchemaType.OBJECT))),
            @APIResponse(responseCode = "400", description = "validation errors",
                    content = @Content(mediaType = APPLICATION_JSON,
                            schema = @Schema(type = SchemaType.OBJECT))),
            @APIResponse(responseCode = "500", description = "system error",
                    content = @Content(mediaType = APPLICATION_JSON,
                            schema = @Schema(type = SchemaType.OBJECT))) })
    public String hello() {
        return "Hello from Quarkus REST";
    }
}
