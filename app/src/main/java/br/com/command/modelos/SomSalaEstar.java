package br.com.command.modelos;

import br.com.command.util.ExternalService;

/**
 * Created by danielmarcoto on 17/11/15.
 */
public class SomSalaEstar {
    private static SomSalaEstar instance;
    private ExternalService externalService;

    private boolean ligado;

    private SomSalaEstar(){
        externalService = ExternalService.getInstance();
    }

    public static SomSalaEstar getInstance(){
        if (instance == null)
            instance = new SomSalaEstar();
        return instance;
    }

    public boolean isLigado(){
        return ligado;
    }

    public void ligar(){
        externalService.chamarServico("Ligar som sala de estar",
                "O micro system da sala de estar será ligado");
        ligado = true;
    }

    public void desligar(){
        externalService.chamarServico("Desligar som sala de estar",
                "O micro system da sala de estar será desligado");
        ligado = false;
    }
}
