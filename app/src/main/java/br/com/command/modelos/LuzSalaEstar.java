package br.com.command.modelos;

import android.os.AsyncTask;
import android.util.Log;

/**
 * Created by danielmarcoto on 17/11/15.
 */
public class LuzSalaEstar extends Controlavel {
    public static final int ID = 4;

    public void ligar(){
        new AsyncTask<String, Integer, String>(){
            @Override
            protected String doInBackground(String... strings) {
                String response = externalService
                        .callRemote("Ligar Luz Sala Estar",
                                "A luz da sala de estar será ligada");

                return response;
            }

            @Override
            protected void onPostExecute(String response) {
                super.onPostExecute(response);

                Log.i("Log", "Response: " + response);

                if (response.startsWith("Erro")){
                    statusController.setLuzSalaEstarLigada(false);
                } else {
                    statusController.setLuzSalaEstarLigada(true);
                }

                if (onStatusChangeListener != null)
                    onStatusChangeListener.onChange(statusController.isLuzSalaEstarLigada());
            }
        }.execute();
    }

    public void desligar(){
        new AsyncTask<String, Integer, String>(){
            @Override
            protected String doInBackground(String... strings) {
                String response = externalService
                        .callRemote("Desligar Luz sala de estar",
                                "A luz da sala de estar será desligada.");

                return response;
            }

            @Override
            protected void onPostExecute(String response) {
                super.onPostExecute(response);

                Log.i("Log", "Response: " + response);

                if (response.startsWith("Erro")){
                    statusController.setLuzSalaEstarLigada(true);
                } else {
                    statusController.setLuzSalaEstarLigada(false);
                }

                if (onStatusChangeListener != null)
                    onStatusChangeListener.onChange(statusController.isLuzSalaEstarLigada());
            }
        }.execute();
    }
}
