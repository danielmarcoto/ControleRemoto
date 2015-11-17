package br.com.command.modelos;

import br.com.command.util.ExternalService;

/**
 * Created by danielmarcoto on 17/11/15.
 */
public class LuzExterna {
    private static LuzExterna instance;
    private ExternalService externalService;

    private boolean ligada;

    private LuzExterna(){
        externalService = ExternalService.getInstance();
    }

    public static LuzExterna getInstance(){
        if (instance == null)
            instance = new LuzExterna();
        return instance;
    }

    public boolean isLigada() {
        return ligada;
    }

    public void ligar(){
        externalService.chamarServico("Ligar luz", "A luz será ligada");
        ligada = true;
    }

    public void desligar(){
        externalService.chamarServico("Desligar luz", "A luz será desligada");
        ligada = false;
    }
}
