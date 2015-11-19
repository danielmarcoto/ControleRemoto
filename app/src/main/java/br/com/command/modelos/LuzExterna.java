package br.com.command.modelos;

import android.os.AsyncTask;
import android.util.Log;

/**
 * Created by danielmarcoto on 17/11/15.
 */
public class LuzExterna extends Controlavel {

    public final static int ID = 3;

    public void ligar(){
        new AsyncTask<String, Integer, String>(){
            @Override
            protected String doInBackground(String... strings) {
                String response = externalService
                        .callRemote("Ligar Luz Externa", "A luz externa será ligada");

                return response;
            }

            @Override
            protected void onPostExecute(String response) {
                super.onPostExecute(response);

                Log.i("Log", "Response: " + response);

                if (response.startsWith("Erro")){
                    statusController.setLuzExternaLigada(false);
                } else {
                    statusController.setLuzExternaLigada(true);
                }

                if (onStatusChangeListener != null)
                    onStatusChangeListener.onChange(statusController.isLuzExternaLigada());
            }
        }.execute();
    }

    public void desligar(){
        new AsyncTask<String, Integer, String>(){
            @Override
            protected String doInBackground(String... strings) {
                String response = externalService
                        .callRemote("Desligar Luz Externa",
                                "A luz externa da garagem não dá limites.");

                return response;
            }

            @Override
            protected void onPostExecute(String response) {
                super.onPostExecute(response);

                Log.i("Log", "Response: " + response);

                if (response.startsWith("Erro")){
                    statusController.setLuzExternaLigada(true);
                } else {
                    statusController.setLuzExternaLigada(false);
                }

                if (onStatusChangeListener != null)
                    onStatusChangeListener.onChange(statusController.isLuzExternaLigada());
            }
        }.execute();
    }
}
