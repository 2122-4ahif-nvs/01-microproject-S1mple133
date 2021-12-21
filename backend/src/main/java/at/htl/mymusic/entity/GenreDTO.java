package at.htl.mymusic.entity;

import java.util.List;

public class GenreDTO {
    public String name;
    public String[] aliases;

    public GenreDTO() {

    }

    public GenreDTO(String name, String[] aliases) {
        this.name = name;
        this.aliases = aliases;
    }
}
