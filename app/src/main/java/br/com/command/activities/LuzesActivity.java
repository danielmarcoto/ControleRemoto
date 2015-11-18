package br.com.command.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ToggleButton;

import br.com.command.comandos.LuzExternaCommand;
import br.com.command.comandos.LuzSalaEstarCommand;
import br.com.command.comandos.LuzSuiteCommand;
import br.com.command.interfaces.Command;
import br.com.command.modelos.LuzExterna;
import br.com.command.modelos.LuzSalaEstar;
import br.com.command.modelos.LuzSuite;

public class LuzesActivity extends AppCompatActivity {

    private ToggleButton toggleLuzSalaEstar;
    private ToggleButton toggleLuzExterna;
    private ToggleButton toggleLuzSuite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_luzes);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        LuzExterna luzExterna = LuzExterna.getInstance();
        LuzSuite luzSuite = LuzSuite.getInstance();
        LuzSalaEstar luzSalaEstar = LuzSalaEstar.getInstance();

        Command luzExternaCommand = new LuzExternaCommand(luzExterna);
        Command luzSalaEstarCommand = new LuzSalaEstarCommand(luzSalaEstar);
        Command luzSuiteCommand = new LuzSuiteCommand(luzSuite);

        toggleLuzExterna = (ToggleButton) findViewById(R.id.tgbLuzExterna);
        toggleLuzSalaEstar = (ToggleButton) findViewById(R.id.tgbLuzDaSalaDeEstar);
        toggleLuzSuite = (ToggleButton) findViewById(R.id.tgbLuzDaSuite);

        toggleLuzExterna.setChecked(luzExterna.isLigada());
        toggleLuzSalaEstar.setChecked(luzSalaEstar.isLigada());
        toggleLuzSuite.setChecked(luzSuite.isLigada());

        toggleLuzExterna.setOnClickListener(new CommandOnClick(luzExternaCommand));
        toggleLuzSalaEstar.setOnClickListener(new CommandOnClick(luzSalaEstarCommand));
        toggleLuzSuite.setOnClickListener(new CommandOnClick(luzSuiteCommand));
    }

}
