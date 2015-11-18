package br.com.command.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ToggleButton;

import br.com.command.comandos.PersianaSalaEstarCommand;
import br.com.command.comandos.PersianaSuiteCommand;
import br.com.command.interfaces.Command;
import br.com.command.modelos.PersianaSalaEstar;
import br.com.command.modelos.PersianaSuite;

public class PersianasActivity extends AppCompatActivity {

    private ToggleButton togglePersianaSalaEstar;
    private ToggleButton togglePersianaSuite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_persianas);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        PersianaSalaEstar persianaSalaEstar = PersianaSalaEstar.getInstance();
        PersianaSuite persianaSuite = PersianaSuite.getInstance();

        Command persianaSalaEstarCommand = new PersianaSalaEstarCommand(persianaSalaEstar);
        Command persianaSuiteCommand = new PersianaSuiteCommand(persianaSuite);

        togglePersianaSalaEstar = (ToggleButton) findViewById(R.id.tgbPersianaSalaDeEstar);
        togglePersianaSuite = (ToggleButton) findViewById(R.id.tgbPersianaSuite);

        togglePersianaSuite.setChecked(persianaSuite.isAberta());
        togglePersianaSalaEstar.setChecked(persianaSalaEstar.isAberta());

        togglePersianaSalaEstar.setOnClickListener(new CommandOnClick(persianaSalaEstarCommand));
        togglePersianaSuite.setOnClickListener(new CommandOnClick(persianaSuiteCommand));
    }

}
