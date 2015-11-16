package br.com.command.command;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ToggleButton;

import br.com.command.comandos.PortaoPrincipalAbrirCommand;
import br.com.command.comandos.PortaoPrincipalFecharCommand;
import br.com.command.comandos.Status;
import br.com.command.interfaces.Command;
import br.com.command.modelos.Portao;

public class PortasPortoesActivity extends AppCompatActivity {

    Portao portao;
    Command comando;

    private ToggleButton mToogle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_portas_portoes);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mToogle = (ToggleButton) findViewById(R.id.tgbPortaoPrincipal);
        portao = Portao.getInstante();

        mToogle.setChecked(portao.isEstado());

        comando = new PortaoPrincipalAbrirCommand(portao);

        mToogle.setOnClickListener(new CommandOnClick(comando));

        /*
        mToogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                comando.execute();
            }
        });
        */
    }

    public void acionarPortaoPrincipal(View view){
        comando.execute();
    }

}
