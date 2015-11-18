package br.com.command.modelos;

import br.com.command.util.ExternalService;

/**
 * Created by danielmarcoto on 17/11/15.
 */
public class AquecedorSuite {

    private static AquecedorSuite instance;
    private ExternalService externalService;

    private boolean ligado;

    private AquecedorSuite(){
        externalService = ExternalService.getInstance();
    }

    public static AquecedorSuite getInstance(){
        if (instance == null)
            instance = new AquecedorSuite();
        return instance;
    }

    public boolean isLigado(){
        return ligado;
    }

    public void ligar(){
        externalService.chamarServico("Ligar aquecedor suite",
                "O aquecedor da suite será ligado");
        ligado = true;
    }

    public void desligar(){
        externalService.chamarServico("Desligar aquecedor suite",
                "O aquecedor da suite será desligado");
        ligado = false;
    }
}
