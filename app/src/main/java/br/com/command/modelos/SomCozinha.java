package br.com.command.modelos;

import br.com.command.util.ExternalService;

/**
 * Created by danielmarcoto on 17/11/15.
 */
public class SomCozinha {
    private static SomCozinha instance;
    private ExternalService externalService;

    private boolean ligado;

    private SomCozinha(){
        externalService = ExternalService.getInstance();
    }

    public static SomCozinha getInstance(){
        if (instance == null)
            instance = new SomCozinha();
        return instance;
    }

    public boolean isLigado(){
        return ligado;
    }

    public void ligar(){
        externalService.chamarServico("Ligar som da cozinha",
                "O micro system da cozinha será ligada");
        ligado = true;
    }

    public void desligar(){
        externalService.chamarServico("Desligar som da cozinha",
                "O micro system da cozinha será desligada");
        ligado = false;
    }
}
