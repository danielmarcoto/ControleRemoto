package br.com.command.modelos;

import android.util.Log;

import br.com.command.interfaces.ServiceStatus;
import br.com.command.util.ExternalService;

/**
 * Created by danielmarcoto on 16/11/15.
 */
public class Portao {

    private boolean aberto;
    private boolean erro;
    private ExternalService externalService;
    private static Portao instance;

    private Portao() {
        externalService = ExternalService.getInstance();
    }

    public static Portao getInstance() {
        if (instance == null) {
            instance = new Portao();
        }
        return instance;
    }

    public boolean isAberto() {
        return aberto;
    }

    public void abrir() throws Exception {
        try {
            externalService.chamarServico(
                    "Abrir Portão",
                    "Abrir o portão da garagem",
                    new ServiceStatus() {
                        @Override
                        public void callbackIfSuccess() {
                            aberto = true;
                        }

                        @Override
                        public void callbackIfFail() {
                            aberto = false;
                            Log.i("Teste", "Estou no callbackIfFail");
                        }
                    });
        } catch (Throwable e) {
            throw new Exception("Erro");
        }

    }

    public void fechar() {
        externalService.chamarServico(
                "Fechar Portão",
                "Fechar o portão da garagem",
                new ServiceStatus() {
                    @Override
                    public void callbackIfSuccess() {
                        aberto = false;
                    }

                    @Override
                    public void callbackIfFail() {
                        aberto = true;
                    }
                });
    }
}
