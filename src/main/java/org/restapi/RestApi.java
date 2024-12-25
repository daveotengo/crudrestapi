package org.restapi;

import io.smallrye.common.constraint.NotNull;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.controller.PersonModel;
import org.domain.Person;

import java.util.List;

@Path("/persons")
@Produces(MediaType.APPLICATION_JSON)
public class RestApi {

    @GET
    public Response getList() {
        List<Person> persons = Person.findAll().list();
        return Response.ok(persons).build();
    }

    @GET
    @Path("{id}")
    public Response getList(@PathParam("id") Long id) {
        Person person = Person.findById(id);
        return Response.ok(person).build();
    }

    @POST
    @Transactional
    public Response save(@NotNull PersonModel model){
        Person person = new Person(model.firstName, model.lastName, model.otherName);
        person.persist();
        return Response.ok(person).build();
    }

    @PUT
    @Transactional
    @Path("{id}")
    public Response update(@PathParam("id") Long id, @NotNull PersonModel model){
        Person person = Person.findById(id);
        if (person==null){
            throw new WebApplicationException("Person with this id does not exist",404);
        }
        person.firstName=model.firstName;
        person.lastName=model.lastName;
        person.otherName= model.otherName;
        person.persist();
        return Response.ok(person).build();
    }

    @PUT
    @Transactional
    @Path("{id}")
    public Response delete(@PathParam("id") Long id){
        Person person = Person.findById(id);
        if (person==null){
            throw new WebApplicationException("Person with this id does not exist",404);
        }
        person.delete();
        return Response.ok("Deleted successfully").build();
    }
}
