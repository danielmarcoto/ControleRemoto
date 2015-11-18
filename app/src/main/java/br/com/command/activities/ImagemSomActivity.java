package br.com.command.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ToggleButton;

import br.com.command.comandos.SomCozinhaCommand;
import br.com.command.comandos.SomPiscinaCommand;
import br.com.command.comandos.SomSalaEstarCommand;
import br.com.command.comandos.SomSuiteCommand;
import br.com.command.comandos.TvSalaEstarCommand;
import br.com.command.interfaces.Command;
import br.com.command.modelos.SomCozinha;
import br.com.command.modelos.SomPiscina;
import br.com.command.modelos.SomSalaEstar;
import br.com.command.modelos.SomSuite;
import br.com.command.modelos.TvSalaEstar;

public class ImagemSomActivity extends AppCompatActivity {

    private ToggleButton toggleSomSalaEstar;
    private ToggleButton toggleSomSuite;
    private ToggleButton toggleSomPiscina;
    private ToggleButton toggleSomCozinha;
    private ToggleButton toggleTvSalaEstar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imagem_som);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        SomCozinha somCozinha = SomCozinha.getInstance();
        SomSuite somSuite = SomSuite.getInstance();
        SomPiscina somPiscina = SomPiscina.getInstance();
        SomSalaEstar somSalaEstar = SomSalaEstar.getInstance();
        TvSalaEstar tvSalaEstar = TvSalaEstar.getInstance();

        Command somCozinhaCommand = new SomCozinhaCommand(somCozinha);
        Command somSuiteCommand = new SomSuiteCommand(somSuite);
        Command somPiscinaCommand = new SomPiscinaCommand(somPiscina);
        Command somSalaEstarCommand = new SomSalaEstarCommand(somSalaEstar);
        Command tvSalaEstarCommand = new TvSalaEstarCommand(tvSalaEstar);

        toggleSomCozinha = (ToggleButton) findViewById(R.id.tgbMicroSystemCozinha);
        toggleSomSuite = (ToggleButton) findViewById(R.id.tgbMicroSystemSuite);
        toggleSomPiscina = (ToggleButton) findViewById(R.id.tgbMicroSystemPiscina);
        toggleSomSalaEstar = (ToggleButton) findViewById(R.id.tgbMicroSystemSalaEstar);
        toggleTvSalaEstar = (ToggleButton) findViewById(R.id.tgbTelevisorDaSalaDeEstar);

        toggleSomCozinha.setChecked(somCozinha.isLigado());
        toggleSomPiscina.setChecked(somPiscina.isLigado());
        toggleSomSuite.setChecked(somSuite.isLigado());
        toggleSomSalaEstar.setChecked(somSalaEstar.isLigado());
        toggleTvSalaEstar.setChecked(tvSalaEstar.isLigado());

        toggleSomSuite.setOnClickListener(new CommandOnClick(somSuiteCommand));
        toggleSomCozinha.setOnClickListener(new CommandOnClick(somCozinhaCommand));
        toggleSomPiscina.setOnClickListener(new CommandOnClick(somPiscinaCommand));
        toggleSomSalaEstar.setOnClickListener(new CommandOnClick(somSalaEstarCommand));
        toggleTvSalaEstar.setOnClickListener(new CommandOnClick(tvSalaEstarCommand));

    }

}
