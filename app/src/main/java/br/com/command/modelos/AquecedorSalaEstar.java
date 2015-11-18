package br.com.command.modelos;

import br.com.command.util.ExternalService;

/**
 * Created by danielmarcoto on 17/11/15.
 */
public class AquecedorSalaEstar {

    private static AquecedorSalaEstar instance;
    private ExternalService externalService;

    private boolean ligado;

    private AquecedorSalaEstar(){
        externalService = ExternalService.getInstance();
    }

    public static AquecedorSalaEstar getInstance(){
        if (instance == null)
            instance = new AquecedorSalaEstar();
        return instance;
    }

    public boolean isLigado(){
        return ligado;
    }

    public void ligar(){
        externalService.chamarServico("Ligar aquecedor sala estar",
                "O aquecedor da sala de estar será ligado");
        ligado = true;
    }

    public void desligar(){
        externalService.chamarServico("Desligar aquecedor sala estar",
                "O aquecedor da sala de estar será desligado");
        ligado = false;
    }
}
