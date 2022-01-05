package at.htl.mymusic.control;

import at.htl.mymusic.entity.Genre;
import io.quarkus.hibernate.reactive.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GenreRepository implements PanacheRepository<Genre> {
}
