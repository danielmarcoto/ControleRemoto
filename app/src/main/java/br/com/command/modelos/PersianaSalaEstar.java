package br.com.command.modelos;

import br.com.command.util.ExternalService;

/**
 * Created by danielmarcoto on 17/11/15.
 */
public class PersianaSalaEstar {

    private static PersianaSalaEstar instance;
    private ExternalService externalService;

    private boolean aberta;

    private PersianaSalaEstar(){
        externalService = ExternalService.getInstance();
    }

    public static PersianaSalaEstar getInstance(){
        if (instance == null)
            instance = new PersianaSalaEstar();
        return instance;
    }

    public boolean isAberta(){
        return aberta;
    }

    public void fechar(){
        externalService.chamarServico("Fechar persiana sala estar",
                "A persiana da sala de estar será fechada");
        aberta = false;
    }

    public void abrir(){
        externalService.chamarServico("Abrir persiana sala estar",
                "A persiana da sala de estar será aberta");
        aberta = true;
    }
}
