package br.com.command.util;

import android.app.Service;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;

import br.com.command.interfaces.ServiceStatus;

/*
 * Created by danielmarcoto on 14/11/15.
 */
public class HttpRequestTask extends AsyncTask<String, Integer, String> {

    private ServiceStatus serviceStatus;
    private Context context;

    public HttpRequestTask() {}

    public HttpRequestTask(ServiceStatus serviceStatus, Context context) {
        this.serviceStatus = serviceStatus;
        this.context = context;
    }

    @Override
    protected String doInBackground(String... strings) {
        //String urlStr = "http://10..196.27:8080/ws/services/control?C=" + comando + "&M=" + mensagem;

        // Correto
        //String urlStr = "http://10.4.192.169/~danielmarcoto/app-server/?C=" + strings[0] + "&M=" + strings[1];
        //Incorreto
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
        } /* finally {
            if (in != null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }*/
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

        Log.i("Log", "---Resultado da requisição: " + s);

        // Modificar o estado
        if (serviceStatus == null) return;

        if (s.startsWith("Erro")){
            serviceStatus.callbackIfFail();
            notifyProblem(s);
        } else {
            serviceStatus.callbackIfSuccess();
        }
    }

    public String readIt(InputStream stream, int len) throws IOException {
        Reader reader;
        reader = new InputStreamReader(stream, "UTF-8");
        char[] buffer = new char[len];
        reader.read(buffer);
        return new String(buffer);
    }

    private void notifyProblem(String message){
        if (context == null) return;

        Toast.makeText(context,
                "Não foi possível carregar o servidor remoto. " + message,
                Toast.LENGTH_LONG).show();
    }
}
