
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.algebra.model;

import hr.algebra.utils.DateAdapter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 *
 * @author Jo
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Movie implements Comparable<Movie> {

    /**
     *
     */
    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ISO_LOCAL_DATE;
    @XmlAttribute
    private int id;
    @XmlElement(name = "title")
    private String Title;
    @XmlJavaTypeAdapter(DateAdapter.class)
    @XmlElement(name = "publisheddate")
    private LocalDate PubDate;
    @XmlElement(name = "description")
    private String Description;
    @XmlElement(name = "originaltitle")
    private String OrigiTitle;
    @XmlElement(name = "director")
    private Director director;
    @XmlElementWrapper
    @XmlElement(name = "actors")
    private List<Actor> actors;
    @XmlElement(name = "duration")
    private int duration;
    @XmlElement(name = "genre")
    private String genre;
    @XmlElement(name = "picturepath")
    private String PicturePath;

    public Movie(int id, String Title, String Description, String OrigiTitle, Director director, List<Actor> actors, int duration, String genre, String PicturePath) {
        this.id = id;
        this.Title = Title;
        this.Description = Description;
        this.OrigiTitle = OrigiTitle;
        this.director = director;
        this.actors = actors;
        this.duration = duration;
        this.genre = genre;
        this.PicturePath = PicturePath;
    }

    public Movie(int id, String Title, LocalDate PubDate, String Description, String OrigiTitle, Director director, int duration, String genre, String PicturePath) {
        this.id = id;
        this.Title = Title;
        this.PubDate = PubDate;
        this.Description = Description;
        this.OrigiTitle = OrigiTitle;
        this.director = director;
        this.duration = duration;
        this.genre = genre;
        this.PicturePath = PicturePath;
    }

    public Movie(int id, String Title, LocalDate PubDate, String Description, String OrigiTitle, List<Actor> actors, int duration, String genre, String PicturePath) {
        this.id = id;
        this.Title = Title;
        this.PubDate = PubDate;
        this.Description = Description;
        this.OrigiTitle = OrigiTitle;
        this.actors = actors;
        this.duration = duration;
        this.genre = genre;
        this.PicturePath = PicturePath;
    }

    public Movie() {
    }

    public Movie(String Title) {
        this.Title = Title;
    }

    public Movie(int id, String Title, LocalDate PubDate, String Description, String OrigiTitle, Director director, List<Actor> actors/*String actors*/, int duration, String genre, String PicturePath) {
        this(Title, PubDate, Description, OrigiTitle, director, actors, duration, genre, PicturePath);
        this.id = id;
    }

    public Movie(String Title, LocalDate PubDate, String Description, String OrigiTitle, Director director, List<Actor> actors /*String actors*/, int duration, String genre, String PicturePath) {
        this.Title = Title;
        this.PubDate = PubDate;
        this.Description = Description;
        this.OrigiTitle = OrigiTitle;

        this.director = director;
        this.actors = actors;
        this.duration = duration;
        this.genre = genre;
        this.PicturePath = PicturePath;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public LocalDate getPubDate() {
        return PubDate;
    }

    public void setPubDate(LocalDate PubDate) {
        this.PubDate = PubDate;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public String getOrigiTitle() {
        return OrigiTitle;
    }

    public void setOrigiTitle(String OrigiTitle) {
        this.OrigiTitle = OrigiTitle;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director directors) {
        this.director = directors;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPicturePath() {
        return PicturePath;
    }

    public void setPicturePath(String PicturePath) {
        this.PicturePath = PicturePath;
    }

    @Override
    public String toString() {
        return Title;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Movie other = (Movie) obj;
        return this.id == other.id;
    }

    @Override
    public int compareTo(Movie o) {
        return this.getTitle().compareTo(o.getTitle());
    }

}
