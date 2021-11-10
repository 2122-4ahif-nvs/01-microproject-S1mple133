package at.htl.mymusic.control;

import at.htl.mymusic.entity.Artist;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class ArtistRepository {
    @Inject
    EntityManager em;

    @Transactional
    public Artist save(Artist artist) {
        return em.merge(artist);
    }

    public List<Artist> getAllArtists() {
        return em.createNamedQuery("Artist.findAll", Artist.class).getResultList();
    }
}
