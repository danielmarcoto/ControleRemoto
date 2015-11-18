package br.com.command.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ToggleButton;

import br.com.command.comandos.AquecedorCorredorCommand;
import br.com.command.comandos.AquecedorSalaEstarCommand;
import br.com.command.comandos.AquecedorSuiteCommand;
import br.com.command.modelos.AquecedorCorredor;
import br.com.command.modelos.AquecedorSalaEstar;
import br.com.command.modelos.AquecedorSuite;

public class AquecedoresActivity extends AppCompatActivity {

    private ToggleButton toggleAquecedorSalaEstar;
    private ToggleButton toggleAquecedorCorredor;
    private ToggleButton toggleAquecedorSuite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aquecedores);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        AquecedorCorredor aquecedorCorredor = AquecedorCorredor.getInstance();
        AquecedorSuite aquecedorSuite = AquecedorSuite.getInstance();
        AquecedorSalaEstar aquecedorSalaEstar = AquecedorSalaEstar.getInstance();

        AquecedorCorredorCommand aquecedorCorredorCommand =
                new AquecedorCorredorCommand(aquecedorCorredor);
        AquecedorSalaEstarCommand aquecedorSalaEstarCommand =
                new AquecedorSalaEstarCommand(aquecedorSalaEstar);
        AquecedorSuiteCommand aquecedorSuiteCommand =
                new AquecedorSuiteCommand(aquecedorSuite);

        toggleAquecedorCorredor = (ToggleButton)
                findViewById(R.id.tgbAquecedorDoCorredorDosQuartos);
        toggleAquecedorSalaEstar = (ToggleButton)
                findViewById(R.id.tgbAquecedorSalaDeEstar);
        toggleAquecedorSuite = (ToggleButton)
                findViewById(R.id.tgbAquecedorDaSuite);

        toggleAquecedorCorredor.setChecked(aquecedorCorredor.isLigado());
        toggleAquecedorSuite.setChecked(aquecedorSuite.isLigado());
        toggleAquecedorSalaEstar.setChecked(aquecedorSalaEstar.isLigado());

        toggleAquecedorCorredor.setOnClickListener(new CommandOnClick(aquecedorCorredorCommand));
        toggleAquecedorSalaEstar.setOnClickListener(new CommandOnClick(aquecedorSalaEstarCommand));
        toggleAquecedorSuite.setOnClickListener(new CommandOnClick(aquecedorSuiteCommand));


    }

}
