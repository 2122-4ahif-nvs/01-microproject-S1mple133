package at.htl.mymusic.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.quarkus.hibernate.reactive.panache.PanacheEntityBase;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "mm_genre_alias")
public class GenreAlias extends PanacheEntityBase implements Serializable
{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ga_id")
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "ga_genre")
    @JsonIgnoreProperties("aliases")
    private Genre genre;

    @Column(name = "ga_alias")
    private String alias;

    //region Constructor
    public GenreAlias() {
    }

    public GenreAlias(Genre genre, String alias) {
        this.genre = genre;
        this.alias = alias;
    }
    //endregion

    //region Getter and Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }
    //endregion


    @Override
    public String toString() {
        return alias;
    }
}
