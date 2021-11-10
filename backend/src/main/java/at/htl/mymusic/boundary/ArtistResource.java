package at.htl.mymusic.boundary;

import at.htl.mymusic.control.ArtistRepository;
import at.htl.mymusic.entity.Artist;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/artist")
public class ArtistResource {
    @Inject
    ArtistRepository artistRepository;

    @Path("/save")
    @POST
    @Consumes("application/json")
    @Produces(MediaType.APPLICATION_JSON)
    public Response saveArtist(Artist artist) {
        return Response.ok(artistRepository.save(artist)).build();
    }

    @Path("/get/all")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllArtists() {
        return Response.ok(artistRepository.getAllArtists()).build();
    }
}
