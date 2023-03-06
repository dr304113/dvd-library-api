package com.hibernate.dvdlibrary.entity;

import jakarta.persistence.*;

import java.io.File;
import java.util.Objects;

@Entity
@Table(name = "Dvd")
public class Dvd {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "director")
    private String director;

    @Column(name = "rating")
    private String rating;

    @Column(name = "notes")
    private String notes;

    @Column(name = "picture")
    private File picture;

    public Dvd() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public File getPicture() {
        return picture;
    }

    public void setPicture(File picture) {
        this.picture = picture;
    }

    @Override
    public String toString() {
        return "Dvd{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", director='" + director + '\'' +
                ", rating='" + rating + '\'' +
                ", notes='" + notes + '\'' +
                ", picture=" + picture +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Dvd dvd)) return false;
        return id == dvd.id && Objects.equals(title, dvd.title) && Objects.equals(director, dvd.director) && Objects.equals(rating, dvd.rating) && Objects.equals(notes, dvd.notes) && Objects.equals(picture, dvd.picture);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, director, rating, notes, picture);
    }
}
