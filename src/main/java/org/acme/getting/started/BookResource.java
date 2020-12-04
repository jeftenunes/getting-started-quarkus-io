package org.acme.getting.started;

import org.acme.getting.started.services.BookService;

import javax.ws.rs.*;
import java.util.Optional;
import javax.inject.Inject;
import javax.ws.rs.core.MediaType;

@Path("books")
public class BookResource {

    @Inject
    BookService service;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getBook() {
        return service.getBooks(Optional.empty());
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getBook(@PathParam("id") Integer id) {
        return service.getBooks(Optional.of(id));
    }

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public String addBook(String book) {
        service.addBook(book);
        return service.getBooks(Optional.empty());
    }
}