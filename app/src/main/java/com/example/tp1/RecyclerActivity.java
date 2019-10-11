package com.example.tp1;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import java.util.ArrayList;
import java.util.List;

import Adapter.RecyclerAdapter;
import Model.Client;
//import Repositories.ClientRepository;
//import RoomDb.ClientDatabase;
import Model.Movie;
import RoomDb.ClientDatabase;
import RoomDb.MovieDatabase;


//tuto minimaliste pour roomdb : https://www.freecodecamp.org/news/room-sqlite-beginner-tutorial-2e725e47bfab/

public class RecyclerActivity  extends AppCompatActivity {

    private List<Client> mesClients;
    private RecyclerAdapter monRecyclerAdapter;

    private static final String DATABASE_NAME = "client_db";
    private ClientDatabase clientDatabase;

    private static final boolean POPULATE_DB = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_activity);

        clientDatabase = Room.databaseBuilder(getApplicationContext(), ClientDatabase.class, DATABASE_NAME)
                        .fallbackToDestructiveMigration()
                        .build();


         //populate la db si necessaire
        if(POPULATE_DB) {
            try {
                populateDataBase();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //viens loader les clients dans mesClients
        try {
            loadClients();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        RecyclerView monRecycler = findViewById(R.id.recyclerView);
        monRecyclerAdapter = new RecyclerAdapter(this, mesClients);
        monRecycler.setAdapter(monRecyclerAdapter);
        monRecycler.setLayoutManager(new LinearLayoutManager(this));
    }

    public void addClient(Client client){
        insertClient(client);
        mesClients.add(client);
        monRecyclerAdapter.notifyDataSetChanged();
    }

    public void onNouveauClientClicked(View view) {
        Intent navigateMainActivity = new Intent(getApplicationContext(), MainActivity.class);
        startActivityForResult(navigateMainActivity, 0);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent intent){
        super.onActivityResult(requestCode, resultCode, intent);
        Client monClient = intent.getParcelableExtra("client");
        addClient(monClient);
    }


    public void populateDataBase() throws InterruptedException {
        Thread populate = new Thread(() -> {
            clientDatabase.clientDao()
                    .insert(new Client("lebosq",
                                    "yannael",
                                    "28/06/1989",
                                    "st brieuc",
                                "cotes d'armor"));

            clientDatabase.clientDao()
                    .insert(new Client("pouessel",
                            "nadege",
                            "12/09/1990",
                            "vitre",
                            "ille et vilaine"));

            clientDatabase.clientDao()
                    .insert(new Client("toto",
                            "tata",
                            "05/05/2010",
                            "paris",
                            "ille de france"));
        });
        populate.start();
        populate.join();
    }

    public void loadClients() throws InterruptedException {
        Thread loader = new Thread(new Runnable() {
            @Override
            public void run() {
                mesClients = clientDatabase.clientDao().getAllClients();
            }
        });
        loader.start();
        loader.join();
    }

    public void insertClient(Client client){
        Thread insert = new Thread(new Runnable() {
            @Override
            public void run() {
                clientDatabase.clientDao().insert(client);
            }
        });
        insert.start();
    }
}
