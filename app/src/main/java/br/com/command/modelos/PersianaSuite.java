package br.com.command.modelos;

import android.os.AsyncTask;
import android.util.Log;

import br.com.command.util.ExternalService;
import br.com.command.util.OnStatusChangeListener;

/**
 * Created by danielmarcoto on 17/11/15.
 */
public class PersianaSuite {

    public final static int ID = 7;
    private OnStatusChangeListener onStatusChangeListener;
    private ExternalService externalService;
    private StatusController statusController;

    public void setOnStatusChangeListener(OnStatusChangeListener onStatusChangeListener) {
        this.onStatusChangeListener = onStatusChangeListener;
    }


    public PersianaSuite() {
        this.externalService = ExternalService.getInstance();
        this.statusController = StatusController.getInstance();
    }

    public void abrir() {
        new AsyncTask<String, Integer, String>() {
            @Override
            protected String doInBackground(String... strings) {
                String response = externalService
                        .callRemote("Abrir persiana sala estar", "A persiana da sala de estar será aberta");

                return response;
            }

            @Override
            protected void onPostExecute(String response) {
                super.onPostExecute(response);

                Log.i("Log", "Response: " + response);

                if (response.startsWith("Erro")) {
                    statusController.setPersianaSuiteAberta(false);
                } else {
                    statusController.setPersianaSuiteAberta(true);
                }

                if (onStatusChangeListener != null)
                    onStatusChangeListener.onChange(statusController.isPersianaSuiteAberta());
            }
        }.execute();

    }

    public void fechar() {
        new AsyncTask<String, Integer, String>() {
            @Override
            protected String doInBackground(String... strings) {
                String response = externalService
                        .callRemote("Fechar persiana sala estar", "A persiana da sala de estar será fechada");

                return response;
            }

            @Override
            protected void onPostExecute(String response) {
                super.onPostExecute(response);

                if (response.startsWith("Erro")) {
                    statusController.setPersianaSuiteAberta(true);
                } else {
                    statusController.setPersianaSuiteAberta(false);
                }

                if (onStatusChangeListener != null)
                    onStatusChangeListener.onChange(statusController.isPersianaSuiteAberta());
            }
        }.execute();
    }
}
