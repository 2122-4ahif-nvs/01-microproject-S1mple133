package at.htl.mymusic.control;

import at.htl.mymusic.entity.Artist;
import io.agroal.api.AgroalDataSource;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;
import org.assertj.db.type.Table;

import javax.inject.Inject;

import static org.assertj.db.api.Assertions.assertThat;

@QuarkusTest
class ArtistRepositoryTest {
    @Inject
    AgroalDataSource dataSource;

    @Inject
    ArtistRepository artistRepository;

    @Test
    void testAdd() {
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
}