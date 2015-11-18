package br.com.command.modelos;

import br.com.command.util.ExternalService;

/**
 * Created by danielmarcoto on 17/11/15.
 */
public class SomPiscina {
    private static SomPiscina instance;
    private ExternalService externalService;

    private boolean ligado;

    private SomPiscina(){
        externalService = ExternalService.getInstance();
    }

    public static SomPiscina getInstance(){
        if (instance == null)
            instance = new SomPiscina();
        return instance;
    }

    public boolean isLigado(){
        return ligado;
    }

    public void ligar(){
        externalService.chamarServico("Ligar som da piscina",
                "O micro system da piscina será ligada");
        ligado = true;
    }

    public void desligar(){
        externalService.chamarServico("Desligar som da piscina",
                "O micro system da piscina será desligada");
        ligado = false;
    }
}
