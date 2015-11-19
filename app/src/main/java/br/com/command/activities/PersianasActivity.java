package br.com.command.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ToggleButton;

import br.com.command.comandos.ControleRemoto;
import br.com.command.comandos.GaragemAbrirCommand;
import br.com.command.comandos.GaragemFecharCommand;
import br.com.command.comandos.PersianaSalaEstarAbrirCommand;
import br.com.command.comandos.PersianaSalaEstarFecharCommand;
import br.com.command.comandos.PersianaSuiteAbrirCommand;
import br.com.command.comandos.PersianaSuiteFecharCommand;
import br.com.command.comandos.PortaPrincipalAbrirCommand;
import br.com.command.comandos.PortaPrincipalFecharCommand;
import br.com.command.comandos.PortaoAbrirCommand;
import br.com.command.comandos.PortaoFecharCommand;
import br.com.command.interfaces.Command;
import br.com.command.modelos.Garagem;
import br.com.command.modelos.PersianaSalaEstar;
import br.com.command.modelos.PersianaSuite;
import br.com.command.modelos.Porta;
import br.com.command.modelos.Portao;
import br.com.command.modelos.StatusController;
import br.com.command.util.OnStatusChangeListener;

public class PersianasActivity extends AppCompatActivity {

    private ToggleButton togglePersianaSalaEstar;
    private ToggleButton togglePersianaSuite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_persianas);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        StatusController statusController = StatusController.getInstance();

        togglePersianaSalaEstar = (ToggleButton) findViewById(R.id.tgbPersianaSalaDeEstar);
        togglePersianaSuite = (ToggleButton) findViewById(R.id.tgbPersianaSuite);



        PersianaSuite persianaSuite = new PersianaSuite();
        persianaSuite.setOnStatusChangeListener(new OnStatusChangeListener() {
            @Override
            public void onChange(boolean newStatus) {
                togglePersianaSuite.setChecked(newStatus);
            }
        });

        PersianaSalaEstar persianaSalaEstar = new PersianaSalaEstar();
        persianaSalaEstar.setOnStatusChangeListener(new OnStatusChangeListener() {
            @Override
            public void onChange(boolean newStatus) {
                togglePersianaSalaEstar.setChecked(newStatus);
            }
        });




        Command persianaSalaEstarAbrirCommand = new PersianaSalaEstarAbrirCommand(persianaSalaEstar);
        Command persianaSalaEstarFecharCommand = new PersianaSalaEstarFecharCommand(persianaSalaEstar);

        Command persianaSuiteAbrirCommand = new PersianaSuiteAbrirCommand(persianaSuite);
        Command persianaSuiteFecharCommand = new PersianaSuiteFecharCommand(persianaSuite);

        ControleRemoto controleRemoto = new ControleRemoto();
        controleRemoto.setCommand(PersianaSalaEstar.ID, persianaSalaEstarAbrirCommand, persianaSalaEstarFecharCommand);
        controleRemoto.setCommand(PersianaSuite.ID, persianaSuiteAbrirCommand, persianaSuiteFecharCommand);

        togglePersianaSalaEstar.setChecked(statusController.isPersianaSalaEstarAberta());
        togglePersianaSuite.setChecked(statusController.isPersianaSuiteAberta());

        togglePersianaSalaEstar.setOnClickListener(new CommandOnClick(PersianaSalaEstar.ID, controleRemoto));
        togglePersianaSuite.setOnClickListener(new CommandOnClick(PersianaSuite.ID, controleRemoto));
    }

}
