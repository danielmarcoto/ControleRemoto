package br.com.command.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ToggleButton;

import br.com.command.comandos.ControleRemoto;
import br.com.command.comandos.GaragemAbrirCommand;
import br.com.command.comandos.GaragemCommand;
import br.com.command.comandos.GaragemFecharCommand;
import br.com.command.comandos.PortaPrincipalCommand;
import br.com.command.comandos.PortaoPrincipalCommand;
import br.com.command.interfaces.Command;
import br.com.command.interfaces.ServiceStatus;
import br.com.command.modelos.Garagem;
import br.com.command.modelos.Porta;
import br.com.command.modelos.Portao;
import br.com.command.util.ExternalService;
import br.com.command.util.OnStatusChangeListener;

public class PortasPortoesActivity extends AppCompatActivity {

    private ToggleButton tooglePortaoPrincipal;
    private ToggleButton togglePortaPrincipal;
    private ToggleButton toggleGaragem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_portas_portoes);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tooglePortaoPrincipal = (ToggleButton) findViewById(R.id.tgbPortaoPrincipal);
        togglePortaPrincipal = (ToggleButton) findViewById(R.id.tgbPortaPrincipal);
        toggleGaragem = (ToggleButton) findViewById(R.id.tgbGaragem);

        ExternalService externalService = ExternalService.getInstance();

        Portao portao = Portao.getInstance();
        Porta porta = Porta.getInstance();
        //Garagem garagem = Garagem.getInstance();



        Garagem garagem = new Garagem(externalService);
        garagem.setOnStatusChangeListener(new OnStatusChangeListener() {
            @Override
            public void onChange(boolean newStatus) {

                toggleGaragem.setChecked(newStatus);
            }
        });

        Command portaoPrincipalCommand = new PortaoPrincipalCommand(portao);
        Command portaPrincipalCommand = new PortaPrincipalCommand(porta);

        Command garagemAbrirCommand = new GaragemAbrirCommand(garagem);
        Command garagemFecharCommand = new GaragemFecharCommand(garagem);

        ControleRemoto controleRemoto = new ControleRemoto();
        controleRemoto.setCommand(Garagem.ID, garagemAbrirCommand, garagemFecharCommand);



        tooglePortaoPrincipal.setChecked(portao.isAberto());
        togglePortaPrincipal.setChecked(porta.isAberta());
        toggleGaragem.setChecked(garagem.isAberta());

        tooglePortaoPrincipal.setOnClickListener(new CommandOnClick(portaoPrincipalCommand));
        togglePortaPrincipal.setOnClickListener(new CommandOnClick(portaPrincipalCommand));
        toggleGaragem.setOnClickListener(new CommandOnClick(Garagem.ID, controleRemoto));


    }

}
