package RoomDb;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import DAO.MovieDao;
import Model.Movie;

@Database(entities = {Movie.class}, version = 1, exportSchema = false)
public abstract class MovieDatabase extends RoomDatabase {

    public abstract MovieDao movieDao() ;
}
