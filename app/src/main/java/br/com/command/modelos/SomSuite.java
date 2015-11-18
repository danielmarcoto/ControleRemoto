package br.com.command.modelos;

import br.com.command.util.ExternalService;

/**
 * Created by danielmarcoto on 17/11/15.
 */
public class SomSuite {
    private static SomSuite instance;
    private ExternalService externalService;

    private boolean ligado;

    private SomSuite(){
        externalService = ExternalService.getInstance();
    }

    public static SomSuite getInstance(){
        if (instance == null)
            instance = new SomSuite();
        return instance;
    }

    public boolean isLigado(){
        return ligado;
    }

    public void ligar(){
        externalService.chamarServico("Ligar som suite",
                "O micro system da suíte será ligado");
        ligado = true;
    }

    public void desligar(){
        externalService.chamarServico("Desligar som suite",
                "O micro system da suíte será desligado");
        ligado = false;
    }
}
