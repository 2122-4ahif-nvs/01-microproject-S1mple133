package at.htl.mymusic.control;

import at.htl.mymusic.entity.Album;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AlbumRepository implements PanacheRepository<Album> {
}
