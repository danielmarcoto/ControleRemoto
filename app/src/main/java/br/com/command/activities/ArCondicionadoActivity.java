package br.com.command.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ToggleButton;

import br.com.command.comandos.ArCondicionadoCorredorDesligarCommand;
import br.com.command.comandos.ArCondicionadoCorredorLigarCommand;
import br.com.command.comandos.ArCondicionadoSalaEstarDesligadoCommand;
import br.com.command.comandos.ArCondicionadoSalaEstarLigarCommand;
import br.com.command.comandos.ArCondicionadoSuiteDesligarCommand;
import br.com.command.comandos.ArCondicionadoSuiteLigarCommand;
import br.com.command.comandos.ControleRemoto;
import br.com.command.comandos.GaragemAbrirCommand;
import br.com.command.comandos.GaragemFecharCommand;
import br.com.command.comandos.PortaPrincipalAbrirCommand;
import br.com.command.comandos.PortaPrincipalFecharCommand;
import br.com.command.comandos.PortaoAbrirCommand;
import br.com.command.comandos.PortaoFecharCommand;
import br.com.command.interfaces.Command;
import br.com.command.modelos.ArCondicionadoCorredor;
import br.com.command.modelos.ArCondicionadoSalaEstar;
import br.com.command.modelos.ArCondicionadoSuite;
import br.com.command.modelos.Garagem;
import br.com.command.modelos.Porta;
import br.com.command.modelos.Portao;
import br.com.command.modelos.StatusController;
import br.com.command.util.OnStatusChangeListener;

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

        toggleArCorredor = (ToggleButton) findViewById(R.id.tgbArCondicionadoDoCorredor);
        toggleArSalaEstar = (ToggleButton) findViewById(R.id.tgbArCondicionadoDaSalaDeEstar);
        toggleArSuite = (ToggleButton) findViewById(R.id.tgbArCondicionadoDaSuite);

        StatusController statusController = StatusController.getInstance();

        ArCondicionadoCorredor arCondicionadoCorredor = new ArCondicionadoCorredor();
        arCondicionadoCorredor.setOnStatusChangeListener(new OnStatusChangeListener() {
            @Override
            public void onChange(boolean newStatus) {
                toggleArCorredor.setChecked(newStatus);
            }
        });

        ArCondicionadoSalaEstar arCondicionadoSalaEstar = new ArCondicionadoSalaEstar();
        arCondicionadoSalaEstar.setOnStatusChangeListener(new OnStatusChangeListener() {
            @Override
            public void onChange(boolean newStatus) {
                toggleArSalaEstar.setChecked(newStatus);
            }
        });

        ArCondicionadoSuite arCondicionadoSuite = new ArCondicionadoSuite();
        arCondicionadoSuite.setOnStatusChangeListener(new OnStatusChangeListener() {
            @Override
            public void onChange(boolean newStatus) {
                toggleArSuite.setChecked(newStatus);
            }
        });

        Command arCondicionadoCorredorLigarCommand = new ArCondicionadoCorredorLigarCommand(arCondicionadoCorredor);
        Command arCondicionadoCorredorDesligarCommand = new ArCondicionadoCorredorDesligarCommand(arCondicionadoCorredor);

        Command arCondicionadoSalaEstarLigarCommand = new ArCondicionadoSalaEstarLigarCommand(arCondicionadoSalaEstar);
        Command arCondicionadoSalaEstarDesligadoCommand = new ArCondicionadoSalaEstarDesligadoCommand(arCondicionadoSalaEstar);

        Command arCondicionadoSuiteLigarCommand = new ArCondicionadoSuiteLigarCommand(arCondicionadoSuite);
        Command arCondicionadoSuiteDesligarCommand = new ArCondicionadoSuiteDesligarCommand(arCondicionadoSuite);

        ControleRemoto controleRemoto = new ControleRemoto();
        controleRemoto.setCommand(ArCondicionadoCorredor.ID, arCondicionadoCorredorLigarCommand, arCondicionadoCorredorDesligarCommand);
        controleRemoto.setCommand(ArCondicionadoSalaEstar.ID, arCondicionadoSalaEstarLigarCommand, arCondicionadoSalaEstarDesligadoCommand);
        controleRemoto.setCommand(ArCondicionadoSuite.ID, arCondicionadoSuiteLigarCommand, arCondicionadoSalaEstarDesligadoCommand);

        toggleArCorredor.setChecked(statusController.isArCondicionadoCorredorLigado());
        toggleArSalaEstar.setChecked(statusController.isArCondicionadoSalaEstarLigado());
        toggleArSuite.setChecked(statusController.isArCondicionadoSuiteLigado());

        toggleArCorredor.setOnClickListener(new CommandOnClick(ArCondicionadoCorredor.ID, controleRemoto));
        toggleArSalaEstar.setOnClickListener(new CommandOnClick(ArCondicionadoSalaEstar.ID, controleRemoto));
        toggleArSuite.setOnClickListener(new CommandOnClick(ArCondicionadoSuite.ID, controleRemoto));
    }

}
