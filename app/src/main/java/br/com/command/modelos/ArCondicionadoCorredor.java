package br.com.command.modelos;

import br.com.command.util.ExternalService;

/**
 * Created by danielmarcoto on 17/11/15.
 */
public class ArCondicionadoCorredor {
    private static ArCondicionadoCorredor instance;
    private ExternalService externalService;

    private boolean ligado;

    private ArCondicionadoCorredor(){
        externalService = ExternalService.getInstance();
    }

    public static ArCondicionadoCorredor getInstance(){
        if (instance == null)
            instance = new ArCondicionadoCorredor();
        return instance;
    }

    public boolean isLigado(){
        return ligado;
    }

    public void ligar(){
        externalService.chamarServico("Ligar Ar-condicionado corredor",
                "O ar-condicionado do corredor será ligado");
        ligado = true;
    }

    public void desligar(){
        externalService.chamarServico("Desligar Ar-condicionado corredor",
                "O ar-condicionado do corredor será desligado");
        ligado = false;
    }
}
