package at.htl.mymusic.control;

import at.htl.mymusic.entity.Album;
import at.htl.mymusic.entity.Artist;
import at.htl.mymusic.entity.Genre;
import at.htl.mymusic.entity.GenreAlias;
import io.agroal.api.AgroalDataSource;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;
import org.assertj.db.type.Table;

import javax.inject.Inject;
import javax.transaction.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.db.api.Assertions.assertThat;

@QuarkusTest
class RepositoryTest {
    @Inject
    AgroalDataSource dataSource;

    @Inject
    ArtistRepository artistRepository;

    @Inject
    AlbumRepository albumRepository;

    @Inject
    GenreRepository genreRepository;


    @Test
    @Transactional
    void artist_testAdd() {
        Artist testArtist = new Artist("First", "Last");

        artistRepository.persist(testArtist);

        Table artists = new Table(dataSource, "mm_artist");

        assertThat(artists).column("a_firstname")
                .value().isEqualTo(testArtist.getFirstName());
        assertThat(artists).column("a_lastname")
                .value().isEqualTo(testArtist.getLastName());
        assertThat(artists).column("a_id")
                .value().isEqualTo(testArtist.getId());
    }

    @Test
    @Transactional
    void album_testAdd() {
        Album album = new Album("Let it Be", null, LocalDateTime.now(), null);

        albumRepository.persist(album);

        Table albums = new Table(dataSource, "mm_album");

        assertThat(albums).column("al_img")
                .value().isEqualTo(album.getImage());
        assertThat(albums).column("al_name")
                .value().isEqualTo(album.getName());
        assertThat(albums).column("al_publication_date")
                .value().isEqualTo(album.getPublicationDate());
        assertThat(albums).column("al_id")
                .value().isEqualTo(album.getId());
    }

    @Test
    @Transactional
    void genre_testAdd() {
        Genre testGenre = new Genre("Rap", new ArrayList<>());

        testGenre.getAliases().add(new GenreAlias(testGenre, "HipHop"));
        testGenre.getAliases().add(new GenreAlias(testGenre, "Trap"));

        genreRepository.persist(testGenre);

        Table genres = new Table(dataSource, "mm_genre");

        assertThat(genres).column("g_name")
                .value().isEqualTo(testGenre.getName());

        Table genreAliases = new Table(dataSource, "mm_genre_alias");

        assertThat(genreAliases).column("ga_genre")
                .value().isEqualTo(testGenre.getId());
        assertThat(genreAliases).column("ga_alias")
                .value().isEqualTo("HipHop")
                .value().isEqualTo("Trap");
    }
}