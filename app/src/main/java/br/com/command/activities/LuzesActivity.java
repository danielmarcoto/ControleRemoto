package br.com.command.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ToggleButton;

import br.com.command.comandos.ControleRemoto;
import br.com.command.comandos.LuzExternaDesligarCommand;
import br.com.command.comandos.LuzExternaLigarCommand;
import br.com.command.comandos.LuzSalaEstarDesligarCommand;
import br.com.command.comandos.LuzSalaEstarLigarCommand;
import br.com.command.comandos.LuzSuiteDesligarCommand;
import br.com.command.comandos.LuzSuiteLigarCommand;
import br.com.command.interfaces.Command;
import br.com.command.modelos.LuzExterna;
import br.com.command.modelos.LuzSalaEstar;
import br.com.command.modelos.LuzSuite;
import br.com.command.modelos.StatusController;
import br.com.command.util.OnStatusChangeListener;

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

        StatusController statusController = StatusController.getInstance();

        toggleLuzExterna = (ToggleButton) findViewById(R.id.tgbLuzExterna);
        toggleLuzSalaEstar = (ToggleButton) findViewById(R.id.tgbLuzDaSalaDeEstar);
        toggleLuzSuite = (ToggleButton) findViewById(R.id.tgbLuzDaSuite);

        LuzExterna luzExterna = new LuzExterna();
        luzExterna.setOnStatusChangeListener(new OnStatusChangeListener() {
            @Override
            public void onChange(boolean newStatus) {
                toggleLuzExterna.setChecked(newStatus);
            }
        });

        LuzSuite luzSuite = new LuzSuite();
        luzSuite.setOnStatusChangeListener(new OnStatusChangeListener() {
            @Override
            public void onChange(boolean newStatus) {
                toggleLuzSuite.setChecked(newStatus);
            }
        });

        LuzSalaEstar luzSalaEstar = new LuzSalaEstar();
        luzSalaEstar.setOnStatusChangeListener(new OnStatusChangeListener() {
            @Override
            public void onChange(boolean newStatus) {
                toggleLuzSalaEstar.setChecked(newStatus);
            }
        });

        Command luzExternaLigarCommand = new LuzExternaLigarCommand(luzExterna);
        Command luzExternaDesligarCommand = new LuzExternaDesligarCommand(luzExterna);

        Command luzSalaEstarLigarCommand = new LuzSalaEstarLigarCommand(luzSalaEstar);
        Command luzSalaEstarDesligarCommand = new LuzSalaEstarDesligarCommand(luzSalaEstar);

        Command luzSuiteLigarCommand = new LuzSuiteLigarCommand(luzSuite);
        Command luzSuiteDesligarCommand = new LuzSuiteDesligarCommand(luzSuite);

        ControleRemoto controleRemoto = new ControleRemoto();
        controleRemoto.setCommand(LuzExterna.ID,
                luzExternaLigarCommand, luzExternaDesligarCommand);
        controleRemoto.setCommand(LuzSalaEstar.ID,
                luzSalaEstarLigarCommand, luzSalaEstarDesligarCommand);
        controleRemoto.setCommand(LuzSuite.ID,
                luzSuiteLigarCommand, luzSuiteDesligarCommand);

        toggleLuzExterna.setChecked(statusController.isLuzExternaLigada());
        toggleLuzSalaEstar.setChecked(statusController.isLuzSalaEstarLigada());
        toggleLuzSuite.setChecked(statusController.isLuzSuiteLigada());

        toggleLuzExterna.setOnClickListener(new CommandOnClick(LuzExterna.ID, controleRemoto));
        toggleLuzSalaEstar.setOnClickListener(new CommandOnClick(LuzSalaEstar.ID, controleRemoto));
        toggleLuzSuite.setOnClickListener(new CommandOnClick(LuzSuite.ID, controleRemoto));
    }
}
