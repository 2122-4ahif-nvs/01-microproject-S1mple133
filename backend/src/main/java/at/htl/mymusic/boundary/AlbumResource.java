package at.htl.mymusic.boundary;

import at.htl.mymusic.ArtistReply;
import at.htl.mymusic.ArtistRequest;
import at.htl.mymusic.ArtistSeeker;
import at.htl.mymusic.boundary.grpc.ArtistService;
import at.htl.mymusic.control.AlbumRepository;
import at.htl.mymusic.control.ArtistRepository;
import at.htl.mymusic.entity.Album;
import at.htl.mymusic.entity.AlbumDTO;
import io.quarkus.grpc.GrpcClient;
import io.quarkus.security.identity.SecurityIdentity;
import io.smallrye.mutiny.Uni;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.validation.Validator;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.Duration;

@Path("/album")
public class AlbumResource {
    @Inject
    Validator validator;

    @Inject
    AlbumRepository albumRepository;

    @Inject
    ArtistRepository artistRepository;

    @Inject
    SecurityIdentity securityIdentity;

    @Path("/save")
    @POST
    @Consumes("application/json")
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response saveAlbum(@Valid AlbumDTO album) {
        if(!securityIdentity.hasRole("Admin")) {
            return Response.status(403).build();
        }

        if(artistRepository.findById(album.artistId).await().atMost(Duration.ofMinutes(1)) == null) {
            return Response.noContent().build();
        }

        Album actAlbum = new Album(album.name,
                album.image,
                album.publicationDate,
                artistRepository.findById(album.artistId).await().atMost(Duration.ofMinutes(1))
        );

        actAlbum = albumRepository.persistAndFlush(actAlbum).await().indefinitely();

        return Response.ok(actAlbum).build();
    }

    @Path("/all")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllAlbums() {
        return Response.ok(albumRepository.listAll().await().indefinitely()).build();
    }
}
