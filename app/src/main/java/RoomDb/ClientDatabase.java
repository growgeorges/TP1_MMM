package RoomDb;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import DAO.ClientDao;
import Model.Client;

@Database(entities = {Client.class}, version = 1, exportSchema = false)
public abstract class ClientDatabase extends RoomDatabase {

    public abstract ClientDao clientDao();
}
