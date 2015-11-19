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
import br.com.command.interfaces.Command;
import br.com.command.modelos.Garagem;
import br.com.command.modelos.Porta;
import br.com.command.modelos.Portao;
import br.com.command.modelos.StatusController;
import br.com.command.util.OnStatusChangeListener;

public class PortasPortoesActivity extends AppCompatActivity {

    private ToggleButton togglePortaoPrincipal;
    private ToggleButton togglePortaPrincipal;
    private ToggleButton toggleGaragem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_portas_portoes);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        StatusController statusController = StatusController.getInstance();

        togglePortaoPrincipal = (ToggleButton) findViewById(R.id.tgbPortaoPrincipal);
        togglePortaPrincipal = (ToggleButton) findViewById(R.id.tgbPortaPrincipal);
        toggleGaragem = (ToggleButton) findViewById(R.id.tgbGaragem);

        Portao portao = new Portao();
        portao.setOnStatusChangeListener(new OnStatusChangeListener() {
            @Override
            public void onChange(boolean newStatus) {
                if (togglePortaoPrincipal.isChecked() != newStatus){
                    Toast.makeText(getApplicationContext(),
                            getString(R.string.notificao_se_erro_servidor),
                            Toast.LENGTH_LONG).show();
                }

                togglePortaoPrincipal.setChecked(newStatus);
            }
        });

        Porta porta = new Porta();
        porta.setOnStatusChangeListener(new OnStatusChangeListener() {
            @Override
            public void onChange(boolean newStatus) {
                if (togglePortaPrincipal.isChecked() != newStatus){
                    Toast.makeText(getApplicationContext(),
                            getString(R.string.notificao_se_erro_servidor),
                            Toast.LENGTH_LONG).show();
                }

                togglePortaPrincipal.setChecked(newStatus);
            }
        });

        Garagem garagem = new Garagem();
        garagem.setOnStatusChangeListener(new OnStatusChangeListener() {
            @Override
            public void onChange(boolean newStatus) {
                if (toggleGaragem.isChecked() != newStatus){
                    Toast.makeText(getApplicationContext(),
                            getString(R.string.notificao_se_erro_servidor),
                            Toast.LENGTH_LONG).show();
                }

                toggleGaragem.setChecked(newStatus);
            }
        });

        Command portaPrincipalAbrirCommand = new PortaPrincipalAbrirCommand(porta);
        Command portaPrincipalFecharCommand = new PortaPrincipalFecharCommand(porta);

        Command garagemAbrirCommand = new GaragemAbrirCommand(garagem);
        Command garagemFecharCommand = new GaragemFecharCommand(garagem);

        Command portaoAbrirCommand = new PortaoAbrirCommand(portao);
        Command portaoFecharCommand = new PortaoFecharCommand(portao);

        ControleRemoto controleRemoto = new ControleRemoto();
        controleRemoto.setCommand(Garagem.ID, garagemAbrirCommand, garagemFecharCommand);
        controleRemoto.setCommand(Portao.ID, portaoAbrirCommand, portaoFecharCommand);
        controleRemoto.setCommand(Porta.ID, portaPrincipalAbrirCommand, portaPrincipalFecharCommand);

        togglePortaoPrincipal.setChecked(statusController.isPortaoAberto());
        togglePortaPrincipal.setChecked(statusController.isPortaAberta());
        toggleGaragem.setChecked(statusController.isGaragemAberta());

        togglePortaPrincipal.setOnClickListener(new CommandOnClick(Porta.ID, controleRemoto));
        togglePortaoPrincipal.setOnClickListener(new CommandOnClick(Portao.ID, controleRemoto));
        toggleGaragem.setOnClickListener(new CommandOnClick(Garagem.ID, controleRemoto));
    }

}
