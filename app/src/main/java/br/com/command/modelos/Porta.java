package br.com.command.modelos;

import android.os.AsyncTask;
import android.util.Log;

/**
 * Created by danielmarcoto on 17/11/15.
 */
public class Porta extends Controlavel {

    public static final int ID = 6;

    public void abrir(){

        new AsyncTask<String, Integer, String>(){
            @Override
            protected String doInBackground(String... strings) {
                String response = externalService
                        .callRemote("Abrir Porta", "A porta será aberta");

                return response;
            }

            @Override
            protected void onPostExecute(String response) {
                super.onPostExecute(response);

                Log.i("Log", "Response: " + response);

                if (response.startsWith("Erro")){
                    statusController.setPortaAberta(false);
                } else {
                    statusController.setPortaAberta(true);
                }

                if (onStatusChangeListener != null)
                    onStatusChangeListener.onChange(statusController.isPortaAberta());
            }
        }.execute();
    }

    public void fechar(){
        new AsyncTask<String, Integer, String>(){
            @Override
            protected String doInBackground(String... strings) {
                String response = externalService
                        .callRemote("Fechar Porta", "A porta será fechada");

                return response;
            }

            @Override
            protected void onPostExecute(String response) {
                super.onPostExecute(response);

                Log.i("Log", "Response: " + response);

                if (response.startsWith("Erro")){
                    statusController.setPortaAberta(true);
                } else {
                    statusController.setPortaAberta(false);
                }

                if (onStatusChangeListener != null)
                    onStatusChangeListener.onChange(statusController.isPortaAberta());
            }
        }.execute();
    }

    public void trancar(){


    }

    public void destrancar(){


    }
}
