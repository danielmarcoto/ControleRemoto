package br.com.command.modelos;

import android.os.AsyncTask;
import android.util.Log;

import br.com.command.util.ExternalService;
import br.com.command.util.OnStatusChangeListener;

/**
 * Created by danielmarcoto on 17/11/15.
 */
public class ArCondicionadoCorredor {
    public final static int ID = 11;
    private OnStatusChangeListener onStatusChangeListener;
    private ExternalService externalService;
    private StatusController statusController;

    public ArCondicionadoCorredor(){
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
                        .callRemote("Ligar Ar-condicionado corredor",
                                "O ar-condicionado do corredor será ligado");

                return response;
            }

            @Override
            protected void onPostExecute(String response) {
                super.onPostExecute(response);

                Log.i("Log", "Response: " + response);

                if (response.startsWith("Erro")){
                    statusController.setArCondicionadoCorredorLigado(false);
                } else {
                    statusController.setArCondicionadoCorredorLigado(true);
                }

                if (onStatusChangeListener != null)
                    onStatusChangeListener.onChange(
                            statusController.isArCondicionadoCorredorLigado());
            }
        }.execute();
    }

    public void desligar(){

        new AsyncTask<String, Integer, String>(){
            @Override
            protected String doInBackground(String... strings) {
                String response = externalService
                        .callRemote("Desligar Ar-condicionado corredor",
                                "O ar-condicionado do corredor será desligado");

                return response;
            }

            @Override
            protected void onPostExecute(String response) {
                super.onPostExecute(response);

                Log.i("Log", "Response: " + response);

                if (response.startsWith("Erro")){
                    statusController.setArCondicionadoCorredorLigado(true);
                } else {
                    statusController.setArCondicionadoCorredorLigado(false);
                }

                if (onStatusChangeListener != null)
                    onStatusChangeListener.onChange(
                            statusController.isArCondicionadoCorredorLigado());
            }
        }.execute();
    }

}
