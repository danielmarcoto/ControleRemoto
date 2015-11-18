package br.com.command.util;

import android.util.Log;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Created by Guilherme on 05/11/2015.
 */
public class ExternalService {

    private static ExternalService instance;
    private boolean isConnected;

    public static ExternalService getInstance() {
        if (instance == null)
            instance = new ExternalService();

        return instance;
    }

    public boolean isConnected() {
        return isConnected;
    }

    public void setIsConnected(boolean isConnected) {
        this.isConnected = isConnected;
    }

    public void chamarServico(String comando, String mensagem) {

        //if (!isConnected) return;

        Log.i("Log", "command:" + comando + " / Message:" + mensagem);

        String comandoParam = null;
        String mensagemParam = null;

        try {
            comandoParam = URLEncoder.encode(comando, "utf-8");
            mensagemParam = URLEncoder.encode(mensagem, "utf-8");
        }
        catch (UnsupportedEncodingException ex){
            ex.printStackTrace();
        }

        String[] parameters = { comandoParam, mensagemParam };

        HttpRequestTask requestTask = new HttpRequestTask();
        requestTask.execute(parameters);
    }
}
