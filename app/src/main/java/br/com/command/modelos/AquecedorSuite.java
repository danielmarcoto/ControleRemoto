package br.com.command.modelos;

import android.os.AsyncTask;
import android.util.Log;

import br.com.command.util.ExternalService;
import br.com.command.util.OnStatusChangeListener;

/**
 * Created by danielmarcoto on 17/11/15.
 */
public class AquecedorSuite {

    public final static int ID = 9;
    private OnStatusChangeListener onStatusChangeListener;
    private ExternalService externalService;
    private StatusController statusController;

    public AquecedorSuite(){
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
                        .callRemote("Ligar aquecedor suite",
                                "O aquecedor da suite será ligado");

                return response;
            }

            @Override
            protected void onPostExecute(String response) {
                super.onPostExecute(response);

                Log.i("Log", "Response: " + response);

                if (response.startsWith("Erro")){
                    statusController.setAquecedorSuiteLigado(false);
                } else {
                    statusController.setAquecedorSuiteLigado(true);
                }

                if (onStatusChangeListener != null)
                    onStatusChangeListener.onChange(statusController.isAquecedorSuiteLigado());
            }
        }.execute();
    }

    public void desligar(){

        new AsyncTask<String, Integer, String>(){
            @Override
            protected String doInBackground(String... strings) {
                String response = externalService
                        .callRemote("Desligar aquecedor suite",
                                "O aquecedor da suite será desligado");

                return response;
            }

            @Override
            protected void onPostExecute(String response) {
                super.onPostExecute(response);

                Log.i("Log", "Response: " + response);

                if (response.startsWith("Erro")){
                    statusController.setAquecedorSuiteLigado(true);
                } else {
                    statusController.setAquecedorSuiteLigado(false);
                }

                if (onStatusChangeListener != null)
                    onStatusChangeListener.onChange(statusController.isAquecedorSuiteLigado());
            }
        }.execute();
    }
}
