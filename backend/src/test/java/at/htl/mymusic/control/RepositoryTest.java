package at.htl.mymusic.control;


import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
class RepositoryTest {
    /*@Inject
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
    } TODO: Fix this, after switching to Reactive, could not find a way to get a reference to DataSorce for assertjDB */
}