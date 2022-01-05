package at.htl.mymusic.boundary;

import at.htl.mymusic.ArtistRequest;
import at.htl.mymusic.ArtistSeeker;
import at.htl.mymusic.control.ArtistRepository;
import at.htl.mymusic.entity.Artist;
import io.quarkus.grpc.GrpcClient;
import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;
import io.smallrye.common.annotation.Blocking;
import io.smallrye.mutiny.Uni;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.Duration;

@Path("/artist")
public class ArtistResource {
    @GrpcClient
    ArtistSeeker seeker;

    @Inject
    Template artist;

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

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/get/{id}")
    public Uni<TemplateInstance> getNameOfArtist(@PathParam("id") int id) {
        return seeker.getArtist(ArtistRequest.newBuilder().setId(id).build())
                .onItem().transform(reply -> artist
                        .data("firstName", reply.getFirstName())
                        .data("lastName", reply.getLastName()));
    }
}
