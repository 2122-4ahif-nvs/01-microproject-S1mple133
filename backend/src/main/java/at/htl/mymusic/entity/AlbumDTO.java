package at.htl.mymusic.entity;

import at.htl.mymusic.control.validator.ExistingAuthor;
import at.htl.mymusic.control.validator.NoBadWord;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class AlbumDTO {
        @NotBlank(message = "Album name may not be blank")
        @NoBadWord
        public String name;
        public byte[] image;
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern ="yyyy-MM-dd HH:mm:ss")
        @NotNull(message = "Publication Date may not be null")
        public LocalDateTime publicationDate;
        @NotNull(message = "Artist id cannot be null!")
        @ExistingAuthor
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
