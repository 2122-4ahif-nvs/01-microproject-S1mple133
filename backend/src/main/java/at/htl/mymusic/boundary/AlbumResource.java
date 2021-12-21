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
        if(!artistRepository.findByIdOptional(album.artistId).isPresent()) {
            return Response.noContent().build();
        }

        Album actAlbum = new Album(album.name,
                album.image,
                album.publicationDate,
                artistRepository.findById(album.artistId)
        );

        albumRepository.persist(actAlbum);

        return Response.ok(actAlbum).build();
    }

    @Path("/all")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllAlbums() {
        return Response.ok(albumRepository.findAll().stream().toArray()).build();
    }
}
