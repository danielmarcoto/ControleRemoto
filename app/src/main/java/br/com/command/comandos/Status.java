package br.com.command.comandos;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import br.com.command.command.HttpRequestTask;
import br.com.command.modelos.Portao;

/**
 * Created by Guilherme on 05/11/2015.
 */
public class Status {

    private static Status instance;
    private List<String> listaMensagem = new ArrayList<>();
    private boolean isConnected;

    public static Status getInstance() {
        if (instance == null)
        {
            instance = new Status();
        }

        return instance;
    }

    public boolean isConnected() {
        return isConnected;
    }

    public void setIsConnected(boolean isConnected) {
        this.isConnected = isConnected;
    }

    public void addMensagem(String texto) {
        listaMensagem.add(texto);
    }

    public void chamarServico(String comando, String mensagem) {

        if (!isConnected) return;

        String[] parameters = { comando, mensagem };

        HttpRequestTask requestTask = new HttpRequestTask();
        requestTask.execute(parameters);
    }
}
