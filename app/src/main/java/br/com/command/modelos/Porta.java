package br.com.command.modelos;

import br.com.command.util.ExternalService;

/**
 * Created by danielmarcoto on 17/11/15.
 */
public class Porta {

    private static Porta instance;
    private ExternalService externalService;

    private boolean aberta;
    private boolean trancada;

    private Porta(){
        externalService = ExternalService.getInstance();
    }

    public static Porta getInstance(){
        if (instance == null)
            instance = new Porta();

        return instance;
    }

    public boolean isAberta() {
        return aberta;
    }

    public boolean isTrancada() {
        return trancada;
    }

    public void abrir(){

        if (trancada)
            destrancar();

        externalService.chamarServico("Abrir a porta", "A porta será aberta");
        aberta = true;
    }

    public void fechar(){
        externalService.chamarServico("Fechar a porta", "A porta será fecharda");
        aberta = false;

        trancar();
    }

    public void trancar(){

        if (aberta) return;

        externalService.chamarServico("Trantar a porta", "A porta será trancada");
        trancada = false;
    }

    public void destrancar(){

        if (aberta) return;

        externalService.chamarServico("Destrantar a porta", "A porta será destrancada");
        trancada = true;
    }
}
