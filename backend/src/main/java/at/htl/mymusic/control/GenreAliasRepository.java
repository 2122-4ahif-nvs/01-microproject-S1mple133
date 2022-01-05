package at.htl.mymusic.control;

import at.htl.mymusic.entity.GenreAlias;
import io.quarkus.hibernate.reactive.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GenreAliasRepository implements PanacheRepository<GenreAlias> {
}
