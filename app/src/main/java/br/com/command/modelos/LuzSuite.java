package br.com.command.modelos;

import br.com.command.util.ExternalService;

/**
 * Created by danielmarcoto on 17/11/15.
 */
public class LuzSuite {
    private static LuzSuite instance;

    private ExternalService externalService;

    private boolean ligada;

    private LuzSuite(){
        externalService = ExternalService.getInstance();
    }

    public static LuzSuite getInstance(){
        if (instance == null)
            instance = new LuzSuite();
        return instance;
    }

    public boolean isLigada() {
        return ligada;
    }

    public void ligar(){
        externalService.chamarServico("Ligar luz da suite",
                "A luz da suite será ligada");
        ligada = true;
    }

    public void desligar(){
        externalService.chamarServico("Desligar a luz da suite",
                "A luz da suite será desligada");
        ligada = false;
    }
}
