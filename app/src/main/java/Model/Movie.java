package Model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Movie {

    @NonNull
    @PrimaryKey
    private String movieId;
    private String movieName;

    public Movie() { }

    public String getMovieId() { return movieId; }

    public void setMovieId(String movieId) { this.movieId = movieId; }

    public String getMovieName() { return movieName; }

    public void setMovieName (String movieName) { this.movieName = movieName; } }