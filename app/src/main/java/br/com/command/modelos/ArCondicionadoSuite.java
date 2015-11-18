package br.com.command.modelos;

import br.com.command.util.ExternalService;

/**
 * Created by danielmarcoto on 17/11/15.
 */
public class ArCondicionadoSuite {
    private static ArCondicionadoSuite instance;
    private ExternalService externalService;

    private boolean ligado;

    private ArCondicionadoSuite(){
        externalService = ExternalService.getInstance();
    }

    public static ArCondicionadoSuite getInstance(){
        if (instance == null)
            instance = new ArCondicionadoSuite();
        return instance;
    }

    public boolean isLigado(){
        return ligado;
    }

    public void ligar(){
        externalService.chamarServico("Ligar Ar-condicionado suíte",
                "O ar-condicionado da suíte será ligado");
        ligado = true;
    }

    public void desligar(){
        externalService.chamarServico("Desligar Ar-condicionado corredor",
                "O ar-condicionado da suíte será desligado");
        ligado = false;
    }
}
