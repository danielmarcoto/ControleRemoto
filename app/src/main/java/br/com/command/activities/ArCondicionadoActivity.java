package br.com.command.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ToggleButton;

import br.com.command.comandos.ArCondicionadoCorredorCommand;
import br.com.command.comandos.ArCondicionadoSalaEstarCommand;
import br.com.command.comandos.ArCondicionadoSuiteCommand;
import br.com.command.interfaces.Command;
import br.com.command.modelos.ArCondicionadoCorredor;
import br.com.command.modelos.ArCondicionadoSalaEstar;
import br.com.command.modelos.ArCondicionadoSuite;

public class ArCondicionadoActivity extends AppCompatActivity {

    private ToggleButton toggleArCorredor;
    private ToggleButton toggleArSalaEstar;
    private ToggleButton toggleArSuite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ar_condicionado);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ArCondicionadoCorredor arCorredor = ArCondicionadoCorredor.getInstance();
        ArCondicionadoSalaEstar arSalaEstar = ArCondicionadoSalaEstar.getInstance();
        ArCondicionadoSuite arSuite = ArCondicionadoSuite.getInstance();

        Command arCorredorCommand = new ArCondicionadoCorredorCommand(arCorredor);
        Command arSalaEstarCommand = new ArCondicionadoSalaEstarCommand(arSalaEstar);
        Command arSuiteCommand = new ArCondicionadoSuiteCommand(arSuite);

        toggleArCorredor = (ToggleButton) findViewById(R.id.tgbArCondicionadoDoCorredor);
        toggleArSalaEstar = (ToggleButton) findViewById(R.id.tgbArCondicionadoDaSalaDeEstar);
        toggleArSuite = (ToggleButton) findViewById(R.id.tgbArCondicionadoDaSuite);

        toggleArCorredor.setChecked(arCorredor.isLigado());
        toggleArSalaEstar.setChecked(arSalaEstar.isLigado());
        toggleArSuite.setChecked(arSuite.isLigado());

        toggleArCorredor.setOnClickListener(new CommandOnClick(arCorredorCommand));
        toggleArSalaEstar.setOnClickListener(new CommandOnClick(arSalaEstarCommand));
        toggleArSuite.setOnClickListener(new CommandOnClick(arSuiteCommand));
    }

}
