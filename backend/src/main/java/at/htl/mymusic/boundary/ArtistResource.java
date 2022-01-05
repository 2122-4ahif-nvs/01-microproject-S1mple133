package at.htl.mymusic.boundary;

import at.htl.mymusic.control.ArtistRepository;
import at.htl.mymusic.entity.Artist;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.Duration;

@Path("/artist")
public class ArtistResource {
    @Inject
    ArtistRepository artistRepository;

    @Path("/save")
    @POST
    @Consumes("application/json")
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response saveArtist(Artist artist) {
        artist = artistRepository.persistAndFlush(artist).await().indefinitely();
        return Response.ok(artist).build();
    }

    @Path("/all")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllArtists() {
        return Response.ok(artistRepository.listAll().await().indefinitely()).build();
    }
}
