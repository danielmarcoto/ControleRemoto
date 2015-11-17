package br.com.command.activities;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import br.com.command.util.ExternalService;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();

        final ExternalService externalService = ExternalService.getInstance();

        externalService.setIsConnected(networkInfo != null && networkInfo.isConnected());

        connMgr.addDefaultNetworkActiveListener(new ConnectivityManager.OnNetworkActiveListener() {
            @Override
            public void onNetworkActive() {
                externalService.setIsConnected(true);
            }
        });
    }

    public void controleDeLuzes(View v) {
        Intent it = new Intent(this, LuzesActivity.class);
        startActivity(it);
    }

    public void controleDePortas(View v) {
        Intent it = new Intent(this, PortasPortoesActivity.class);
        startActivity(it);
    }

    public void controleDeImagemSom(View v) {
        Intent it = new Intent(this, ImagemSomActivity.class);
        startActivity(it);
    }

    public void controleDePersianas(View v) {
        Intent it = new Intent(this, PersianasActivity.class);
        startActivity(it);
    }

    public void controleDeAquecedores(View v) {
        Intent it = new Intent(this, AquecedoresActivity.class);
        startActivity(it);
    }

    public void controleDeArCondicionado(View view) {
        Intent it = new Intent(this, ArCondicionadoActivity.class);
        startActivity(it);
    }
}
