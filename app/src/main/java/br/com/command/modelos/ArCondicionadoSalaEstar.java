package br.com.command.modelos;

import br.com.command.util.ExternalService;

/**
 * Created by danielmarcoto on 17/11/15.
 */
public class ArCondicionadoSalaEstar {
    private static ArCondicionadoSalaEstar instance;
    private ExternalService externalService;

    private boolean ligado;

    private ArCondicionadoSalaEstar(){
        externalService = ExternalService.getInstance();
    }

    public static ArCondicionadoSalaEstar getInstance(){
        if (instance == null)
            instance = new ArCondicionadoSalaEstar();
        return instance;
    }

    public boolean isLigado(){
        return ligado;
    }

    public void ligar(){
        externalService.chamarServico("Ligar Ar-condicionado sala de estar",
                "O ar-condicionado da sala de estar será ligado");
        ligado = true;
    }

    public void desligar(){
        externalService.chamarServico("Desligar Ar-condicionado sala de estar",
                "O ar-condicionado da sala de estar será desligado");
        ligado = false;
    }
}
