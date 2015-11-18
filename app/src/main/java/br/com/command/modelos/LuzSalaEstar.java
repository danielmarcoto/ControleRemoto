package br.com.command.modelos;

import br.com.command.util.ExternalService;

/**
 * Created by danielmarcoto on 17/11/15.
 */
public class LuzSalaEstar {
    private static LuzSalaEstar instance;
    private ExternalService externalService;

    private boolean ligada;

    private LuzSalaEstar(){
        externalService = ExternalService.getInstance();
    }

    public static LuzSalaEstar getInstance(){
        if (instance == null)
            instance = new LuzSalaEstar();
        return instance;
    }

    public boolean isLigada() {
        return ligada;
    }

    public void ligar(){
        externalService.chamarServico("Ligar a Luz da sala de estar",
                "A luz da sala de estar será ligada");
        ligada = true;
    }

    public void desligar(){
        externalService.chamarServico("Desligar a Luz da sala de estar",
                "A luz da sala de estar será desligada");
        ligada = false;
    }
}
