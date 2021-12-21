package at.htl.mymusic.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Arrays;

@Entity
@Table(name = "mm_album")
public class Album extends PanacheEntityBase {
    @Column(name = "al_name", nullable = false)
    private String name;

    @Column(name = "al_img", nullable = true)
    private byte[] image;

    @Column(name = "al_publication_date", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern ="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime publicationDate;

    @ManyToOne(cascade = CascadeType.ALL) @JoinColumn(name = "al_artist", nullable = true)
    Artist artist;

    @Id
    @Column(name = "al_id") @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //region Constructor
    public Album() {

    }

    public Album(String name, byte[] image, LocalDateTime publicationDate, Artist artist) {
        this.name = name;
        this.image = image;
        this.publicationDate = publicationDate.withNano(0).withSecond(0);
        this.artist = artist;
    }
    //endregion


    //region Getter and Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public LocalDateTime getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDateTime publicationDate) {
        this.publicationDate = publicationDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    //endregion


    @Override
    public String toString() {
        return "Album{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
