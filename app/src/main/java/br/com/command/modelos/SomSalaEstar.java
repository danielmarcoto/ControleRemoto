package br.com.command.modelos;

import android.os.AsyncTask;
import android.util.Log;

import br.com.command.util.ExternalService;
import br.com.command.util.OnStatusChangeListener;

/**
 * Created by danielmarcoto on 17/11/15.
 */
public class SomSalaEstar {
    public final static int ID = 16;
    private OnStatusChangeListener onStatusChangeListener;
    private ExternalService externalService;
    private StatusController statusController;

    public SomSalaEstar(){
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
                        .callRemote("Ligar som sala de estar",
                                "O micro system da sala de estar será ligado");

                return response;
            }

            @Override
            protected void onPostExecute(String response) {
                super.onPostExecute(response);

                Log.i("Log", "Response: " + response);

                if (response.startsWith("Erro")){
                    statusController.setSomSalaEstar(false);
                } else {
                    statusController.setSomSalaEstar(true);
                }

                if (onStatusChangeListener != null)
                    onStatusChangeListener.onChange(statusController.isSomSalaEstar());
            }
        }.execute();
    }

    public void desligar(){

        new AsyncTask<String, Integer, String>(){
            @Override
            protected String doInBackground(String... strings) {
                String response = externalService
                        .callRemote("Desligar som sala de estar",
                                "O micro system da sala de estar será desligado");

                return response;
            }

            @Override
            protected void onPostExecute(String response) {
                super.onPostExecute(response);

                Log.i("Log", "Response: " + response);

                if (response.startsWith("Erro")){
                    statusController.setSomSalaEstar(true);
                } else {
                    statusController.setSomSalaEstar(false);
                }

                if (onStatusChangeListener != null)
                    onStatusChangeListener.onChange(statusController.isSomSalaEstar());
            }
        }.execute();
    }

}
