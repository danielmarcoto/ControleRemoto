package br.com.command.modelos;

import br.com.command.util.ExternalService;

/**
 * Created by danielmarcoto on 16/11/15.
 */
public class Portao {

    private boolean aberto;
    private ExternalService s;
    private static Portao instance;

    private Portao(){
        s = ExternalService.getInstance();
    }

    public static Portao getInstante(){
        if (instance == null){
            instance = new Portao();
        }
        return instance;
    }

    public boolean isAberto() {
        return aberto;
    }

    public void abrir(){
        s.chamarServico("Abrir Portão", "Abrir o portão da garagem");
        aberto = true;
    }

    public void fechar(){
        s.chamarServico("Fechar Portão", "Fechar o portão da garagem");
        aberto = false;
    }
}
