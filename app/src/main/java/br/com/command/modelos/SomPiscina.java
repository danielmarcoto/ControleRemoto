package br.com.command.modelos;

import android.os.AsyncTask;
import android.util.Log;

import br.com.command.util.ExternalService;
import br.com.command.util.OnStatusChangeListener;
/**
 * Created by danielmarcoto on 17/11/15.
 */
public class SomPiscina {
    public final static int ID = 17;
    private OnStatusChangeListener onStatusChangeListener;
    private ExternalService externalService;
    private StatusController statusController;

    public SomPiscina(){
        this.externalService = ExternalService.getInstance();
        this.statusController = StatusController.getInstance();
    }

    public void setOnStatusChangeListener(OnStatusChangeListener onStatusChangeListener) {
        this.onStatusChangeListener = onStatusChangeListener;
    }

    public void ligar(){

        new AsyncTask<String, Integer, String>(){
            @Override
            protected String doInBackground(String... strings) {
                String response = externalService
                        .callRemote("Ligar som da piscina",
                                "O micro system da piscina será ligada");

                return response;
            }

            @Override
            protected void onPostExecute(String response) {
                super.onPostExecute(response);

                Log.i("Log", "Response: " + response);

                if (response.startsWith("Erro")){
                    statusController.setSomPiscina(false);
                } else {
                    statusController.setSomPiscina(true);
                }

                if (onStatusChangeListener != null)
                    onStatusChangeListener.onChange(statusController.isSomPiscina());
            }
        }.execute();
    }

    public void desligar(){

        new AsyncTask<String, Integer, String>(){
            @Override
            protected String doInBackground(String... strings) {
                String response = externalService
                        .callRemote("Desligar som da piscina",
                                "O micro system da piscina será desligada");

                return response;
            }

            @Override
            protected void onPostExecute(String response) {
                super.onPostExecute(response);

                Log.i("Log", "Response: " + response);

                if (response.startsWith("Erro")){
                    statusController.setSomPiscina(true);
                } else {
                    statusController.setSomPiscina(false);
                }

                if (onStatusChangeListener != null)
                    onStatusChangeListener.onChange(statusController.isSomPiscina());
            }
        }.execute();
    }

}
