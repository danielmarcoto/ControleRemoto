package br.com.command.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;
import android.widget.ToggleButton;

import br.com.command.comandos.ControleRemoto;
import br.com.command.comandos.GaragemAbrirCommand;
import br.com.command.comandos.GaragemFecharCommand;
import br.com.command.comandos.PortaPrincipalAbrirCommand;
import br.com.command.comandos.PortaPrincipalFecharCommand;
import br.com.command.comandos.PortaoAbrirCommand;
import br.com.command.comandos.PortaoFecharCommand;
import br.com.command.comandos.SomCozinhaDesligarCommand;
import br.com.command.comandos.SomCozinhaLigarCommand;
import br.com.command.comandos.SomPiscinaDesligarCommand;
import br.com.command.comandos.SomPiscinaLigarCommand;
import br.com.command.comandos.SomSalaEstarDesligarCommand;
import br.com.command.comandos.SomSalaEstarLigarCommand;
import br.com.command.comandos.SomSuiteDesligarCommand;
import br.com.command.comandos.SomSuiteLigarCommand;
import br.com.command.comandos.TvSalaEstarDesligarCommand;
import br.com.command.comandos.TvSalaEstarLigarCommand;
import br.com.command.interfaces.Command;
import br.com.command.modelos.Garagem;
import br.com.command.modelos.Porta;
import br.com.command.modelos.Portao;
import br.com.command.modelos.SomCozinha;
import br.com.command.modelos.SomPiscina;
import br.com.command.modelos.SomSalaEstar;
import br.com.command.modelos.SomSuite;
import br.com.command.modelos.StatusController;
import br.com.command.modelos.TvSalaEstar;
import br.com.command.util.OnStatusChangeListener;

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

        StatusController statusController = StatusController.getInstance();

        toggleSomCozinha = (ToggleButton) findViewById(R.id.tgbMicroSystemCozinha);
        toggleSomSuite = (ToggleButton) findViewById(R.id.tgbMicroSystemSuite);
        toggleSomPiscina = (ToggleButton) findViewById(R.id.tgbMicroSystemPiscina);
        toggleSomSalaEstar = (ToggleButton) findViewById(R.id.tgbMicroSystemSalaEstar);
        toggleTvSalaEstar = (ToggleButton) findViewById(R.id.tgbTelevisorDaSalaDeEstar);


        SomCozinha somCozinha = new SomCozinha();
        somCozinha.setOnStatusChangeListener(new OnStatusChangeListener() {
            @Override
            public void onChange(boolean newStatus) {
                if (toggleSomCozinha.isChecked() != newStatus){
                    Toast.makeText(getApplicationContext(),
                            getString(R.string.notificao_se_erro_servidor),
                            Toast.LENGTH_LONG).show();
                }
                toggleSomCozinha.setChecked(newStatus);
            }
        });

        SomSuite somSuite = new SomSuite();
        somSuite.setOnStatusChangeListener(new OnStatusChangeListener() {
            @Override
            public void onChange(boolean newStatus) {
                if (toggleSomSuite.isChecked() != newStatus){
                    Toast.makeText(getApplicationContext(),
                            getString(R.string.notificao_se_erro_servidor),
                            Toast.LENGTH_LONG).show();
                }
                toggleSomSuite.setChecked(newStatus);
            }
        });

        SomPiscina somPiscina = new SomPiscina();
        somPiscina.setOnStatusChangeListener(new OnStatusChangeListener() {
            @Override
            public void onChange(boolean newStatus) {
                if (toggleSomPiscina.isChecked() != newStatus){
                    Toast.makeText(getApplicationContext(),
                            getString(R.string.notificao_se_erro_servidor),
                            Toast.LENGTH_LONG).show();
                }
                toggleSomPiscina.setChecked(newStatus);
            }
        });
        SomSalaEstar somSalaEstar = new SomSalaEstar();
        somSalaEstar.setOnStatusChangeListener(new OnStatusChangeListener() {
            @Override
            public void onChange(boolean newStatus) {
                if (toggleSomSalaEstar.isChecked() != newStatus){
                    Toast.makeText(getApplicationContext(),
                            getString(R.string.notificao_se_erro_servidor),
                            Toast.LENGTH_LONG).show();
                }
                toggleSomSalaEstar.setChecked(newStatus);
            }
        });
        TvSalaEstar tvSalaEstar = new TvSalaEstar();
        tvSalaEstar.setOnStatusChangeListener(new OnStatusChangeListener() {
            @Override
            public void onChange(boolean newStatus) {
                if (toggleTvSalaEstar.isChecked() != newStatus){
                    Toast.makeText(getApplicationContext(),
                            getString(R.string.notificao_se_erro_servidor),
                            Toast.LENGTH_LONG).show();
                }
                toggleTvSalaEstar.setChecked(newStatus);
            }
        });


        Command somCozinhaLigarCommand = new SomCozinhaLigarCommand(somCozinha);
        Command somCozinhaDesligarCommand = new SomCozinhaDesligarCommand(somCozinha);

        Command somPiscinaLigarCommand = new SomPiscinaLigarCommand(somPiscina);
        Command somPiscinaDesligarCommand = new SomPiscinaDesligarCommand(somPiscina);

        Command somSuiteLigarCommand = new SomSuiteLigarCommand(somSuite);
        Command somSuiteDesligarCommand = new SomSuiteDesligarCommand(somSuite);

        Command somSalaEstarLigarCommand = new SomSalaEstarLigarCommand(somSalaEstar);
        Command somSalaEstarDesligarCommand = new SomSalaEstarDesligarCommand(somSalaEstar);

        Command tvSalaEstarLigarCommand = new TvSalaEstarLigarCommand(tvSalaEstar);
        Command tvSalaEstarDesligarCommand = new TvSalaEstarDesligarCommand(tvSalaEstar);


        ControleRemoto controleRemoto = new ControleRemoto();
        controleRemoto.setCommand(SomCozinha.ID, somCozinhaLigarCommand, somCozinhaDesligarCommand);
        controleRemoto.setCommand(SomPiscina.ID, somPiscinaLigarCommand, somPiscinaDesligarCommand);
        controleRemoto.setCommand(SomSalaEstar.ID, somSalaEstarLigarCommand, somSalaEstarDesligarCommand);
        controleRemoto.setCommand(SomSuite.ID, somSuiteLigarCommand, somSuiteDesligarCommand);
        controleRemoto.setCommand(TvSalaEstar.ID, tvSalaEstarLigarCommand, tvSalaEstarDesligarCommand);

        toggleSomCozinha.setChecked(statusController.isSomCozinha());
        toggleSomPiscina.setChecked(statusController.isSomPiscina());
        toggleSomSuite.setChecked(statusController.isSomSuite());
        toggleSomSalaEstar.setChecked(statusController.isSomSalaEstar());
        toggleTvSalaEstar.setChecked(statusController.isTvSalaEstar());

        toggleSomSuite.setOnClickListener(new CommandOnClick(SomSuite.ID, controleRemoto));
        toggleSomCozinha.setOnClickListener(new CommandOnClick(SomCozinha.ID, controleRemoto));
        toggleSomPiscina.setOnClickListener(new CommandOnClick(SomPiscina.ID, controleRemoto));
        toggleSomSalaEstar.setOnClickListener(new CommandOnClick(SomSalaEstar.ID, controleRemoto));
        toggleTvSalaEstar.setOnClickListener(new CommandOnClick(TvSalaEstar.ID, controleRemoto));

    }

}
