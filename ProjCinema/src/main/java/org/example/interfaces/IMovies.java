package org.example.interfaces;

public interface IMovies {
    public int GetIdMovie();
    public String GetTitle();
    public String GetGenre();
    public int GetDuration();

    public void SetIdMovie(int idMovie);
    public void SetTitle(String title);
    public void SetGenre(String genre);
    public void SetDuration(int duration);
}
