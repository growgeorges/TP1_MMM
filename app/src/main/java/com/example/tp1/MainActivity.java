package com.example.tp1;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.Toast;

import java.util.Date;

import Model.Client;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onValiderClicked(View view) {
        String nom = ((TextInputLayout)findViewById(R.id.input_nom)).getEditText().getText().toString();
        String prenom = ((TextInputLayout)findViewById(R.id.input_prenom)).getEditText().getText().toString();
        String dob = ((EditText)findViewById(R.id.input_dob)).getText().toString();
        String ville = ((TextInputLayout)findViewById(R.id.input_ville)).getEditText().getText().toString();
        String departement = ((Spinner) findViewById(R.id.monSpinner)).getSelectedItem().toString();
        Client monClient = new Client(nom, prenom, dob, ville, departement);

        Intent result = new Intent();
        result.putExtra("client", monClient);
        setResult(RESULT_OK, result);
        finish();

        //Intent navigateBackToRecyclerActivity = new Intent(getApplicationContext(), RecyclerActivity.class);
        //navigateBackToRecyclerActivity.putExtra("client", monClient);

        //setResult(RESULT_OK, navigateBackToRecyclerActivity);

        //startActivity(navigateBackToRecyclerActivity);
    }

    public void onResetClicked(MenuItem item) {
        ((TextInputLayout)findViewById(R.id.input_nom)).getEditText().setText("");
        ((TextInputLayout)findViewById(R.id.input_prenom)).getEditText().setText("");
        ((TextInputLayout)findViewById(R.id.input_ville)).getEditText().setText("");
        ((EditText)findViewById(R.id.input_dob)).setText("");
    }

    public void onNumTelClick(MenuItem item) {
        Log.i("test", "test");
        EditText phone = new EditText(getApplicationContext());
        phone.setText("phonenumber");
        phone.setTextColor(Color.BLACK);

        LinearLayout tl = findViewById(R.id.linearlayout);
        //TableLayout.LayoutParams lp = new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.WRAP_CONTENT);

        tl.addView(phone);
    }

    public void onVisiteDepartementClicked(MenuItem item) {
        //on recupere le departement selectionné et on lance une recherche wikipedia dessus
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://fr.wikipedia.org/wiki/" + (((Spinner) findViewById(R.id.monSpinner)).getSelectedItem().toString())));
        startActivity(intent);
    }
}
