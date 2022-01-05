package at.htl.mymusic.boundary;

import at.htl.mymusic.control.ArtistRepository;
import at.htl.mymusic.control.GenreRepository;
import at.htl.mymusic.entity.Artist;
import at.htl.mymusic.entity.Genre;
import at.htl.mymusic.entity.GenreAlias;
import at.htl.mymusic.entity.GenreDTO;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@Path("/genre")
public class GenreResource {
    @Inject
    GenreRepository genreRepository;

    @Path("/save")
    @POST
    @Consumes("application/json")
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response saveGenre(GenreDTO genreDTO) {
        Genre actGenre = new Genre(genreDTO.name, new ArrayList<>());

        actGenre = genreRepository.persistAndFlush(actGenre).await().indefinitely();

        for(String alias : genreDTO.aliases) {
            actGenre.getAliases().add(new GenreAlias(actGenre, alias));
        }

        actGenre = genreRepository.persistAndFlush(actGenre).await().indefinitely(); // 2nd time to flush all genres

        return Response.ok(actGenre).build();
    }

    @Path("/all")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllGenres() {
        return Response.ok(genreRepository.listAll().await().indefinitely()).build();
    }
}
