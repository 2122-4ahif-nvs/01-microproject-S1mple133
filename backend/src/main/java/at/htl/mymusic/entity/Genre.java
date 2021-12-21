package at.htl.mymusic.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "mm_genre")
public class Genre extends PanacheEntityBase {
    @Id @Column(name = "g_id") @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "g_name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "genre", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnoreProperties("genre")
    private List<GenreAlias> aliases;

    //region Constructors
    public Genre() {
    }

    public Genre(String name, List<GenreAlias> aliases) {
        this.name = name;
        this.aliases = aliases;
    }
    //endregion

    //region Getter and Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<GenreAlias> getAliases() {
        return aliases;
    }

    public void setAliases(List<GenreAlias> aliases) {
        this.aliases = aliases;
    }
    //endregion


    @Override
    public String toString() {
        return "Genre{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", aliases=" + aliases +
                '}';
    }
}
