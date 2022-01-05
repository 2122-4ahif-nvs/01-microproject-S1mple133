package at.htl.mymusic.boundary;

import at.htl.mymusic.control.AlbumRepository;
import at.htl.mymusic.control.ArtistRepository;
import at.htl.mymusic.entity.Album;
import at.htl.mymusic.entity.AlbumDTO;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.Duration;

@Path("/album")
public class AlbumResource {
    @Inject
    AlbumRepository albumRepository;

    @Inject
    ArtistRepository artistRepository;

    @Path("/save")
    @POST
    @Consumes("application/json")
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response saveAlbum(AlbumDTO album) {
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
