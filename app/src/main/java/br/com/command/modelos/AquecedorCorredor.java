package br.com.command.modelos;

import br.com.command.util.ExternalService;

/**
 * Created by danielmarcoto on 17/11/15.
 */
public class AquecedorCorredor {

    private static AquecedorCorredor instance;
    private ExternalService externalService;

    private boolean ligado;

    private AquecedorCorredor(){
        externalService = ExternalService.getInstance();
    }

    public static AquecedorCorredor getInstance(){
        if (instance == null)
            instance = new AquecedorCorredor();
        return instance;
    }

    public boolean isLigado(){
        return ligado;
    }

    public void ligar(){
        externalService.chamarServico("Ligar aquecedor corredor",
                "O aquecedor do corredor será ligado");
        ligado = true;
    }

    public void desligar(){
        externalService.chamarServico("Desligar aquecedor corredor",
                "O aquecedor do corredor será desligado");
        ligado = false;
    }
}
