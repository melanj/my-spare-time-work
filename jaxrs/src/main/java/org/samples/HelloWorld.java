package org.samples;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/hello")
public class HelloWorld {

    @GET
    @Path("/echo/{input}")
    @Produces("text/plain")
    @NotNull
    public String ping(	@NotNull(message="input cannot be empty") @Pattern(regexp = "^[0-9]{3}$",message="Index should be 3 digits") @PathParam("input") String input) {
        return input;
    }

    @POST
    @Produces("application/json")
    @Consumes("application/json")
    @Path("/jsonBean")
    @Valid @NotNull
    public Response modifyJson(@Valid  JsonBean input) {
        input.setVal2(input.getVal1());
        return Response.ok().entity(input).build();
    }
}

