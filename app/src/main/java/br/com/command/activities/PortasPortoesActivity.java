package br.com.command.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ToggleButton;

import br.com.command.comandos.GaragemCommand;
import br.com.command.comandos.PortaPrincipalCommand;
import br.com.command.comandos.PortaoPrincipalCommand;
import br.com.command.interfaces.Command;
import br.com.command.modelos.Garagem;
import br.com.command.modelos.Porta;
import br.com.command.modelos.Portao;

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

        Portao portao = Portao.getInstante();
        Porta porta = Porta.getInstance();
        Garagem garagem = Garagem.getInstance();

        Command portaoPrincipalCommand = new PortaoPrincipalCommand(portao);
        Command portaPrincipalCommand = new PortaPrincipalCommand(porta);
        Command garagemCommand = new GaragemCommand(garagem);

        tooglePortaoPrincipal = (ToggleButton) findViewById(R.id.tgbPortaoPrincipal);
        togglePortaPrincipal = (ToggleButton) findViewById(R.id.tgbPortaPrincipal);
        toggleGaragem = (ToggleButton) findViewById(R.id.tgbGaragem);

        tooglePortaoPrincipal.setChecked(portao.isAberto());
        togglePortaPrincipal.setChecked(porta.isAberta());
        toggleGaragem.setChecked(garagem.isAberta());

        tooglePortaoPrincipal.setOnClickListener(new CommandOnClick(portaoPrincipalCommand));
        togglePortaPrincipal.setOnClickListener(new CommandOnClick(portaPrincipalCommand));
        toggleGaragem.setOnClickListener(new CommandOnClick(garagemCommand));
    }

}
