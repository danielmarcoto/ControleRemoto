package br.com.command.modelos;

import br.com.command.util.ExternalService;

/**
 * Created by danielmarcoto on 17/11/15.
 */
public class Garagem {
    private static Garagem instance;
    private ExternalService externalService;

    private boolean aberta;

    private Garagem() {
        externalService = ExternalService.getInstance();
    }

    public static Garagem getInstance(){
        if (instance == null)
            instance = new Garagem();

        return instance;
    }

    public boolean isAberta() {
        return aberta;
    }

    public void abrir(){
        externalService.chamarServico("Abrir a garagem", "A garagem será aberta");
        aberta = true;
    }

    public void fechar(){
        externalService.chamarServico("Fechar a garagem", "A garagem será fechada");
        aberta = false;
    }

}
