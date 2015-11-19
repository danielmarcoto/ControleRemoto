package br.com.command.modelos;

import android.os.AsyncTask;
import android.util.Log;

/**
 * Created by danielmarcoto on 17/11/15.
 */
public class LuzSuite extends Controlavel {

    public final static int ID = 5;

    public void ligar(){
        new AsyncTask<String, Integer, String>(){
            @Override
            protected String doInBackground(String... strings) {
                String response = externalService
                        .callRemote("Ligar Luz Suíte",
                                "A luz da suíte será ligada");

                return response;
            }

            @Override
            protected void onPostExecute(String response) {
                super.onPostExecute(response);

                Log.i("Log", "Response: " + response);

                if (response.startsWith("Erro")){
                    statusController.setLuzSuiteLigada(false);
                } else {
                    statusController.setLuzSuiteLigada(true);
                }

                if (onStatusChangeListener != null)
                    onStatusChangeListener.onChange(statusController.isLuzSuiteLigada());
            }
        }.execute();
    }

    public void desligar(){
        new AsyncTask<String, Integer, String>(){
            @Override
            protected String doInBackground(String... strings) {
                String response = externalService
                        .callRemote("Desligar Luz Suite",
                                "A luz da suíte será desligada.");

                return response;
            }

            @Override
            protected void onPostExecute(String response) {
                super.onPostExecute(response);

                Log.i("Log", "Response: " + response);

                if (response.startsWith("Erro")){
                    statusController.setLuzSuiteLigada(true);
                } else {
                    statusController.setLuzSuiteLigada(false);
                }

                if (onStatusChangeListener != null)
                    onStatusChangeListener.onChange(statusController.isLuzSuiteLigada());
            }
        }.execute();
    }
}
