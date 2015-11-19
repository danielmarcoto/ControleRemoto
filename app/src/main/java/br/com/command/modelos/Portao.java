package br.com.command.modelos;

import android.os.AsyncTask;
import android.util.Log;

/**
 * Created by danielmarcoto on 16/11/15.
 */
public class Portao extends Controlavel {

    public final static int ID = 2;

    public Portao(){
        super();
    }

    public void abrir()  {
        new AsyncTask<String, Integer, String>(){
            @Override
            protected String doInBackground(String... strings) {
                String response = externalService
                        .callRemote("Abrir Portão", "O portão será aberto");

                return response;
            }

            @Override
            protected void onPostExecute(String response) {
                super.onPostExecute(response);

                Log.i("Log", "Response: " + response);

                if (response.startsWith("Erro")){
                    statusController.setPortaoAberto(false);
                } else {
                    statusController.setPortaoAberto(true);
                }

                if (onStatusChangeListener != null)
                    onStatusChangeListener.onChange(statusController.isPortaoAberto());
            }
        }.execute();
    }

    public void fechar() {
        new AsyncTask<String, Integer, String>(){
            @Override
            protected String doInBackground(String... strings) {
                String response = externalService
                        .callRemote("Fechar Portão", "O portão será fechado");

                return response;
            }

            @Override
            protected void onPostExecute(String response) {
                super.onPostExecute(response);

                Log.i("Log", "Response: " + response);

                if (response.startsWith("Erro")){
                    statusController.setPortaoAberto(true);
                } else {
                    statusController.setPortaoAberto(false);
                }

                if (onStatusChangeListener != null)
                    onStatusChangeListener.onChange(statusController.isPortaoAberto());
            }
        }.execute();
    }
}
