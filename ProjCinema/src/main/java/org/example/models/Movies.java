package org.example.models;

import org.example.interfaces.IMovies;

public class Movies implements IMovies {
    private int idMovie;
    private String title;
    private String genre;
    private int duration;

    //Constructors
    public Movies() {}
    public Movies(int idMovie, String title, String genre, int duration) {
        this.idMovie = idMovie;
        this.title = title;
        this.genre = genre;
        this.duration = duration;
    }

    //Getters
    public int GetIdMovie() {
        return idMovie;
    }
    public String GetTitle() {
        return title;
    }
    public String GetGenre() {
        return genre;
    }
    public int GetDuration() {
        return duration;
    }

    //Setters
    public void SetIdMovie(int idMovie) {
        this.idMovie = idMovie;
    }
    public void SetTitle(String title) {
        this.title = title;
    }
    public void SetGenre(String genre) {
        this.genre = genre;
    }
    public void SetDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return idMovie + " | " + title + " | " +  genre + " | " + duration + "min |\n";
    }
}
