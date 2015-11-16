package br.com.command.command;

import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;

/*
 * Created by danielmarcoto on 14/11/15.
 */
public class HttpRequestTask extends AsyncTask<String, Integer, String> {

    @Override
    protected String doInBackground(String... strings) {
        //String urlStr = "http://10..196.27:8080/ws/services/control?C=" + comando + "&M=" + mensagem;
        String urlStr = "http://192.168.0.128/~danielmarcoto/app-server/?C=" + strings[0] + "&M=" + strings[1];
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
            urlConnection.setConnectTimeout(15000 /* milliseconds */);
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
            return "Erro";
        } finally {
            if (in != null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

        // Modificar o estado
    }

    public String readIt(InputStream stream, int len) throws IOException {
        Reader reader;
        reader = new InputStreamReader(stream, "UTF-8");
        char[] buffer = new char[len];
        reader.read(buffer);
        return new String(buffer);
    }
}
