package br.com.command.modelos;

import android.os.AsyncTask;
import android.util.Log;

import br.com.command.util.ExternalService;
import br.com.command.util.OnStatusChangeListener;

/**
 * Created by danielmarcoto on 17/11/15.
 */
public class TvSalaEstar {
    public final static int ID = 14;
    private OnStatusChangeListener onStatusChangeListener;
    private ExternalService externalService;
    private StatusController statusController;

    public TvSalaEstar(){
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
                        .callRemote("Ligar Tv sala de estar",
                                "A Tv da sala de estar será ligada");

                return response;
            }

            @Override
            protected void onPostExecute(String response) {
                super.onPostExecute(response);

                Log.i("Log", "Response: " + response);

                if (response.startsWith("Erro")){
                    statusController.setTvSalaEstar(false);
                } else {
                    statusController.setTvSalaEstar(true);
                }

                if (onStatusChangeListener != null)
                    onStatusChangeListener.onChange(statusController.isTvSalaEstar());
            }
        }.execute();
    }

    public void desligar(){

        new AsyncTask<String, Integer, String>(){
            @Override
            protected String doInBackground(String... strings) {
                String response = externalService
                        .callRemote("Desligar som sala de estar",
                                "A Tv da sala de estar será desligada");

                return response;
            }

            @Override
            protected void onPostExecute(String response) {
                super.onPostExecute(response);

                Log.i("Log", "Response: " + response);

                if (response.startsWith("Erro")){
                    statusController.setTvSalaEstar(true);
                } else {
                    statusController.setTvSalaEstar(false);
                }

                if (onStatusChangeListener != null)
                    onStatusChangeListener.onChange(statusController.isTvSalaEstar());
            }
        }.execute();
    }
}
