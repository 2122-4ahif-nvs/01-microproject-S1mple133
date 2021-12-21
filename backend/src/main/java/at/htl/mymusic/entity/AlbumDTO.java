package at.htl.mymusic.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

public class AlbumDTO {
        public String name;
        public byte[] image;
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern ="yyyy-MM-dd HH:mm:ss")
        public LocalDateTime publicationDate;
        public Long artistId;

        public AlbumDTO() {

        }

        public AlbumDTO(String name, byte[] image, LocalDateTime publicationDate, Long artistId) {
                this.name = name;
                this.image = image;
                this.publicationDate = publicationDate;
                this.artistId = artistId;
        }
}
