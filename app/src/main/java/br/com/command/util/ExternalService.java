package br.com.command.util;

import android.content.Context;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import br.com.command.interfaces.ServiceStatus;

/**
 * Created by Guilherme on 05/11/2015.
 */
public class ExternalService {

    private static ExternalService instance;
    private boolean isConnected;

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    private Context context;

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

    public String callRemote(String comando, String mensagem){

        String[] strings = {comando, mensagem};
        //String urlStr = "http://10..196.27:8080/ws/services/control?C=" + comando + "&M=" + mensagem;

        // Correto
        //String urlStr = "http://10.4.192.169/~danielmarcoto/app-server/?C=" + strings[0] + "&M=" + strings[1];
        // Incorreto
        String urlStr = "http://100.4.192.169/~danielmarcoto/app-server/?C=" + strings[0] + "&M=" + strings[1];

        //String urlStr = "http://192.168.0.128/~danielmarcoto/app-server/?C=teste&M=daniel";

        Log.i("Log", urlStr);

        URL url;
        HttpURLConnection urlConnection;
        String remoteData;
        InputStream in = null;

        try {

            url = new URL(urlStr);

            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setReadTimeout(10000 /* milliseconds */);
            urlConnection.setConnectTimeout(2000 /* milliseconds */);
            urlConnection.setRequestMethod("GET");
            urlConnection.setDoInput(true);

            // Starts the query
            urlConnection.connect();
            int response = urlConnection.getResponseCode();
            Log.d("Log", "The response is: " + response);

            in = urlConnection.getInputStream();

            remoteData = readIt(in, in.available());
            return remoteData;
        } catch (Exception e) {
            e.printStackTrace();
            return "Erro: " + strings[0];
        }
    }

    public void chamarServico(String comando, String mensagem) {

        if (!isConnected) return;

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

    public void chamarServico(String comando, String mensagem, ServiceStatus serviceStatus) {

        if (!isConnected) {
            serviceStatus.callbackIfFail();
        }

        Log.i("Log", "command:" + comando + " / Message:" + mensagem);

        String comandoParam = null;
        String mensagemParam = null;

        try {
            comandoParam = URLEncoder.encode(comando, "utf-8");
            mensagemParam = URLEncoder.encode(mensagem, "utf-8");
        }
        catch (UnsupportedEncodingException ex){
            ex.printStackTrace();
            serviceStatus.callbackIfFail();
        }

        String[] parameters = { comandoParam, mensagemParam };

        HttpRequestTask requestTask = new HttpRequestTask(serviceStatus, context);
        requestTask.execute(parameters);

    }

    public String readIt(InputStream stream, int len) throws IOException {
        Reader reader;
        reader = new InputStreamReader(stream, "UTF-8");
        char[] buffer = new char[len];
        reader.read(buffer);
        return new String(buffer);
    }
}
