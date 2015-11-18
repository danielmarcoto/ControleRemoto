package br.com.command.modelos;

import br.com.command.util.ExternalService;

/**
 * Created by danielmarcoto on 17/11/15.
 */
public class PersianaSuite {

    private static PersianaSuite instance;
    private ExternalService externalService;

    private boolean aberta;

    private PersianaSuite(){
        externalService = ExternalService.getInstance();
    }

    public static PersianaSuite getInstance(){
        if (instance == null)
            instance = new PersianaSuite();
        return instance;
    }

    public boolean isAberta(){
        return aberta;
    }

    public void abrir(){
        externalService.chamarServico("Abrir persiana sala estar",
                "A persiana da sala de estar será aberta");
        aberta = true;
    }

    public void fechar(){
        externalService.chamarServico("Fechar persiana sala estar",
                "A persiana da sala de estar será fechada");
        aberta = false;
    }
}
