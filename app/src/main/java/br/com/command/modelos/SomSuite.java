package br.com.command.modelos;

import android.os.AsyncTask;
import android.util.Log;

import br.com.command.util.ExternalService;
import br.com.command.util.OnStatusChangeListener;

/**
 * Created by danielmarcoto on 17/11/15.
 */
public class SomSuite {
    public final static int ID = 15;
    private OnStatusChangeListener onStatusChangeListener;
    private ExternalService externalService;
    private StatusController statusController;

    public SomSuite(){
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
                        .callRemote("Ligar som suite",
                                "O micro system da suíte será ligado");

                return response;
            }

            @Override
            protected void onPostExecute(String response) {
                super.onPostExecute(response);

                Log.i("Log", "Response: " + response);

                if (response.startsWith("Erro")){
                    statusController.setSomSuite(false);
                } else {
                    statusController.setSomSuite(true);
                }

                if (onStatusChangeListener != null)
                    onStatusChangeListener.onChange(statusController.isSomSuite());
            }
        }.execute();
    }

    public void desligar(){

        new AsyncTask<String, Integer, String>(){
            @Override
            protected String doInBackground(String... strings) {
                String response = externalService
                        .callRemote("Desligar som suite",
                                "O micro system da suíte será desligado");

                return response;
            }

            @Override
            protected void onPostExecute(String response) {
                super.onPostExecute(response);

                Log.i("Log", "Response: " + response);

                if (response.startsWith("Erro")){
                    statusController.setSomSuite(true);
                } else {
                    statusController.setSomSuite(false);
                }

                if (onStatusChangeListener != null)
                    onStatusChangeListener.onChange(statusController.isSomSuite());
            }
        }.execute();
    }
}
