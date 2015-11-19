package br.com.command.modelos;

import android.os.AsyncTask;
import android.util.Log;

import br.com.command.util.ExternalService;
import br.com.command.util.OnStatusChangeListener;

/**
 * Created by danielmarcoto on 17/11/15.
 */
public class Garagem {
    //private static Garagem instance;
    private ExternalService externalService;
    //private StatusController statusController;
    /*
    public OnStatusChangeListener getOnStatusChangeListener() {
        return onStatusChangeListener;
    }*/

    public void setOnStatusChangeListener(OnStatusChangeListener onStatusChangeListener) {
        this.onStatusChangeListener = onStatusChangeListener;
    }

    private OnStatusChangeListener onStatusChangeListener;

    public final static int ID = 1;

    private boolean aberta = false;

    public Garagem(ExternalService externalService) {
        this.externalService = externalService;
        //statusController = StatusController.getInstance();
    }

    public boolean isAberta() {
        return aberta;
    }

    public void abrir(){

        new AsyncTask<String, Integer, String>(){
            @Override
            protected String doInBackground(String... strings) {
                String response = externalService
                        .callRemote("Abrir a garagem", "A garagem será aberta");

                return response;
            }

            @Override
            protected void onPostExecute(String response) {
                super.onPostExecute(response);

                Log.i("Log", "Response: " + response);

                if (response.startsWith("Erro")){
                    aberta = false;
                } else {
                    aberta = true;
                }

                if (onStatusChangeListener != null)
                    onStatusChangeListener.onChange(aberta);
            }
        }.execute();
    }

    public void fechar(){

        new AsyncTask<String, Integer, String>(){
            @Override
            protected String doInBackground(String... strings) {
                String response = externalService
                        .callRemote("Fechar a garagem", "A garagem será fechada");

                return response;
            }

            @Override
            protected void onPostExecute(String response) {
                super.onPostExecute(response);

                Log.i("Log", "Response: " + response);

                if (response.startsWith("Erro")){
                    aberta = true;
                } else {
                    aberta = false;
                }

                if (onStatusChangeListener != null)
                    onStatusChangeListener.onChange(aberta);
            }
        }.execute();
    }

}
