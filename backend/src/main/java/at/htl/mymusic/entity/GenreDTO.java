package at.htl.mymusic.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

public class GenreDTO {
    @NotBlank(message = "Genre may not be blank")
    public String name;
    @NotNull(message = "Aliases may not be blank")
    public String[] aliases;

    public GenreDTO() {

    }

    public GenreDTO(String name, String[] aliases) {
        this.name = name;
        this.aliases = aliases;
    }
}
