package at.htl.mymusic.control;

import at.htl.mymusic.entity.GenreAlias;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GenreAliasRepository implements PanacheRepository<GenreAlias> {
}
