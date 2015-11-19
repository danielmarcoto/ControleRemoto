package br.com.command.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ToggleButton;

import br.com.command.comandos.AquecedorCorredorDesligarCommand;
import br.com.command.comandos.AquecedorCorredorLigarCommand;
import br.com.command.comandos.AquecedorSalaEstarDesligarCommand;
import br.com.command.comandos.AquecedorSalaEstarLigarCommand;
import br.com.command.comandos.AquecedorSuiteDesligarCommand;
import br.com.command.comandos.AquecedorSuiteLigarCommand;
import br.com.command.comandos.ControleRemoto;
import br.com.command.comandos.GaragemAbrirCommand;
import br.com.command.comandos.GaragemFecharCommand;
import br.com.command.comandos.PortaPrincipalAbrirCommand;
import br.com.command.comandos.PortaPrincipalFecharCommand;
import br.com.command.comandos.PortaoAbrirCommand;
import br.com.command.comandos.PortaoFecharCommand;
import br.com.command.interfaces.Command;
import br.com.command.modelos.AquecedorCorredor;
import br.com.command.modelos.AquecedorSalaEstar;
import br.com.command.modelos.AquecedorSuite;
import br.com.command.modelos.Garagem;
import br.com.command.modelos.Porta;
import br.com.command.modelos.Portao;
import br.com.command.modelos.StatusController;
import br.com.command.util.OnStatusChangeListener;

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

        StatusController statusController = StatusController.getInstance();

        toggleAquecedorCorredor = (ToggleButton) findViewById(R.id.tgbAquecedorDoCorredorDosQuartos);
        toggleAquecedorSalaEstar = (ToggleButton) findViewById(R.id.tgbAquecedorSalaDeEstar);
        toggleAquecedorSuite = (ToggleButton) findViewById(R.id.tgbAquecedorDaSuite);

        AquecedorCorredor aquecedorCorredor = new AquecedorCorredor();
        aquecedorCorredor.setOnStatusChangeListener(new OnStatusChangeListener() {
            @Override
            public void onChange(boolean newStatus) {
                toggleAquecedorCorredor.setChecked(newStatus);
            }
        });

        AquecedorSalaEstar aquecedorSalaEstar = new AquecedorSalaEstar();
        aquecedorSalaEstar.setOnStatusChangeListener(new OnStatusChangeListener() {
            @Override
            public void onChange(boolean newStatus) {
                toggleAquecedorSalaEstar.setChecked(newStatus);
            }
        });

        AquecedorSuite aquecedorSuite = new AquecedorSuite();
        aquecedorSuite.setOnStatusChangeListener(new OnStatusChangeListener() {
            @Override
            public void onChange(boolean newStatus) {
                toggleAquecedorSuite.setChecked(newStatus);
            }
        });


        Command aquecedorCorredorLigarCommand = new AquecedorCorredorLigarCommand(aquecedorCorredor);
        Command aquecedorCorredorDesligarCommand = new AquecedorCorredorDesligarCommand(aquecedorCorredor);

        Command aquecedorSalaEstarDesligarCommand = new AquecedorSalaEstarDesligarCommand(aquecedorSalaEstar);
        Command aquecedorSalaEstarLigarCommand = new AquecedorSalaEstarLigarCommand(aquecedorSalaEstar);

        Command aquecedorSuiteLigarCommand = new AquecedorSuiteLigarCommand(aquecedorSuite);
        Command aquecedorSuiteDesligarCommand = new AquecedorSuiteDesligarCommand(aquecedorSuite);


        ControleRemoto controleRemoto = new ControleRemoto();
        controleRemoto.setCommand(AquecedorCorredor.ID, aquecedorCorredorLigarCommand, aquecedorCorredorDesligarCommand);
        controleRemoto.setCommand(AquecedorSalaEstar.ID, aquecedorSalaEstarLigarCommand, aquecedorSalaEstarDesligarCommand);
        controleRemoto.setCommand(AquecedorSuite.ID, aquecedorSuiteLigarCommand, aquecedorSuiteDesligarCommand);

        toggleAquecedorCorredor.setChecked(statusController.isAquecedorCorredorLigado());
        toggleAquecedorSalaEstar.setChecked(statusController.isAquecedorSalaEstarLigado());
        toggleAquecedorSuite.setChecked(statusController.isAquecedorSuiteLigado());

        toggleAquecedorCorredor.setOnClickListener(new CommandOnClick(AquecedorCorredor.ID, controleRemoto));
        toggleAquecedorSalaEstar.setOnClickListener(new CommandOnClick(AquecedorSalaEstar.ID, controleRemoto));
        toggleAquecedorSuite.setOnClickListener(new CommandOnClick(AquecedorSuite.ID, controleRemoto));

    }

}
