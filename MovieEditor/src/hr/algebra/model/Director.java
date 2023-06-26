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
public class Director {

    @XmlAttribute
    private int id;
    @XmlElement(name = "directorname")
    private String directorName;
    @XmlElement(name = "picturepath")
    private String PicturePath;
    @XmlElementWrapper
    @XmlElement(name = "movie")
    private List<Movie> movies;

    public Director(int id, String directorName, String PicturePath, List<Movie> movies) {
        this.id = id;
        this.directorName = directorName;
        this.PicturePath = PicturePath;

        this.movies = movies;
    }

    public Director(String directorName, String PicturePath, List<Movie> movies) {
        this.directorName = directorName;
        this.PicturePath = PicturePath;
        this.movies = movies;
    }

    public Director(String directorName) {
        this.directorName = directorName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public String getPicturePath() {
        return PicturePath;
    }

    public void setPicturePath(String PicturePath) {
        this.PicturePath = PicturePath;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    @Override
    public String toString() {
        return directorName;
    }

}
