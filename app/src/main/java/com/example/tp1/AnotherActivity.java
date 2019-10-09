package com.example.tp1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class AnotherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.anotheractivitylayout);

        Intent monIntent =  getIntent();
//        String test = monIntent.getStringExtra("test");

        //on recupere les infos de l'intent et on map ca dans les cases qui vont bien :
        ((TextView)findViewById(R.id.tv_nom)).setText(monIntent.getStringExtra("nom"));
        ((TextView)findViewById(R.id.tv_prenom)).setText(monIntent.getStringExtra("prenom"));
        ((TextView)findViewById(R.id.tv_dob)).setText(monIntent.getStringExtra("dob"));
        ((TextView)findViewById(R.id.tv_ville)).setText(monIntent.getStringExtra("ville"));
        ((TextView)findViewById(R.id.tv_departement)).setText(monIntent.getStringExtra("departement"));
    }
}
