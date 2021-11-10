package at.htl.mymusic.entity;

import javax.persistence.*;

@Entity
@Table(name = "mm_artist")
@NamedQueries(
        @NamedQuery(name = "Artist.findAll", query = "select a from Artist a")
)
public class Artist {
    @Column(name = "a_firstname")
    String firstName;
    @Column(name = "a_lastname")
    String lastName;

    @Id @Column(name="a_id") @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    //region Constructors
    public Artist(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Artist() {
    }
    //endregion

    //region Getters and Setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    //endregion

    @Override
    public String toString() {
        return "Artist{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", id=" + id +
                '}';
    }
}
