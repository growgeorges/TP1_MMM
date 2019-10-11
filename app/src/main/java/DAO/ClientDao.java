package DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import Model.Client;

@Dao
public interface ClientDao {

    @Insert
    void insert(Client client);

    @Update
    void update(Client client);

    @Delete
    void delete(Client client);

    @Query("DELETE FROM Client")
    void deleteAllClients();

    @Query("SELECT * FROM Client")
    List<Client> getAllClients();

}
