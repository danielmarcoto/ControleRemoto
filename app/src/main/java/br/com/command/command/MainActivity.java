package br.com.command.command;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    }

    public void controleDeLuzes(View v) {
        Intent it = new Intent(this, LuzesActivity.class);
        startActivity(it);
    }

    public void controleDePortas(View v) {
        Intent it = new Intent(this, PortasPortoesActivity.class);
        startActivity(it);
    }

    public void controleDeImagemSom(View v) {
        Intent it = new Intent(this, ImagemSomActivity.class);
        startActivity(it);
    }

    public void controleDePersianas(View v) {
        Intent it = new Intent(this, PersianasActivity.class);
        startActivity(it);
    }

    public void controleDeAquecedores(View v) {
        Intent it = new Intent(this, AquecedoresActivity.class);
        startActivity(it);
    }

    public void controleDeArCondicionado(View view) {
        Intent it = new Intent(this, ArCondicionadoActivity.class);
        startActivity(it);
    }
}
