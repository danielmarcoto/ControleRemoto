package br.com.command.modelos;

import br.com.command.util.ExternalService;

/**
 * Created by danielmarcoto on 17/11/15.
 */
public class TvSalaEstar {
    private static TvSalaEstar instance;
    private ExternalService externalService;

    private boolean ligado;

    private TvSalaEstar(){
        externalService = ExternalService.getInstance();
    }

    public static TvSalaEstar getInstance(){
        if (instance == null)
            instance = new TvSalaEstar();
        return instance;
    }

    public boolean isLigado(){
        return ligado;
    }

    public void ligar(){
        externalService.chamarServico("Ligar Tv sala de estar",
                "A Tv da sala de estar será ligada");
        ligado = true;
    }

    public void desligar(){
        externalService.chamarServico("Desligar som sala de estar",
                "A Tv da sala de estar será desligada");
        ligado = false;
    }
}
