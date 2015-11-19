package br.com.command.modelos;

import android.os.AsyncTask;
import android.util.Log;

import br.com.command.util.ExternalService;
import br.com.command.util.OnStatusChangeListener;

/**
 * Created by danielmarcoto on 17/11/15.
 */
public class Garagem {

    public final static int ID = 1;
    private OnStatusChangeListener onStatusChangeListener;
    private ExternalService externalService;
    private StatusController statusController;

    public Garagem(){
        this.externalService = ExternalService.getInstance();
        this.statusController = StatusController.getInstance();
    }

    public void setOnStatusChangeListener(OnStatusChangeListener onStatusChangeListener) {
        this.onStatusChangeListener = onStatusChangeListener;
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
                    statusController.setGaragemAberta(false);
                } else {
                    statusController.setGaragemAberta(true);
                }

                if (onStatusChangeListener != null)
                    onStatusChangeListener.onChange(statusController.isGaragemAberta());
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
                    statusController.setGaragemAberta(true);
                } else {
                    statusController.setGaragemAberta(false);
                }

                if (onStatusChangeListener != null)
                    onStatusChangeListener.onChange(statusController.isGaragemAberta());
            }
        }.execute();
    }

}
