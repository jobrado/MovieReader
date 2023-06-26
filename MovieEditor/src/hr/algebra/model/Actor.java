/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.algebra.model;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

/**
 *
 * @author Jo
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Actor {

    @XmlAttribute
    private int id;
    @XmlElement(name = "actorname")
    private String firstName;
    @XmlElement(name = "picturepath")
    private String picturePath;
    @XmlElementWrapper
    @XmlElement(name = "movie")
    private List<Movie> movies;

    public Actor(String firstName, String picturePath, List<Movie> movies) {
        this.firstName = firstName;
        this.picturePath = picturePath;
        this.movies = movies;
    }

    public Actor() {
    }

    public Actor(int id, String firstName, String picturePath, List<Movie> movies) {
        this(firstName, picturePath, movies);
        this.id = id;

    }

    public Actor(String firstName) {
        this.firstName = firstName;

    }

    public String getPicturePath() {
        return picturePath;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    @Override
    public String toString() {
        return firstName;
    }

}
