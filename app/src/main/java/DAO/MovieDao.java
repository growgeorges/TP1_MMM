package DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import Model.Movie;

@Dao
public interface MovieDao {

    @Insert
    void insertOnlySingleMovie (Movie movies);

    @Insert
    void insertMultipleMovies (List<Movie> moviesList);

    @Query("SELECT * FROM Movie WHERE movieId = :movieId")
    Movie fetchOneMoviesbyMovieId (int movieId);

    @Update
    void updateMovie (Movie movies);

    @Delete
    void deleteMovie (Movie movies);

    @Query("SELECT * FROM Movie")
    List<Movie> fetchAllMovies();


}
