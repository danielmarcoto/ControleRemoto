package br.com.command.modelos;


import br.com.command.util.ExternalService;

/**
 * Created by Guilherme on 05/11/2015.
 */
public class TV {

    ExternalService s = ExternalService.getInstance();

    public void on(){
        s.chamarServico("TV ligada", "Mensagem vinda do Daniel");
    }

    public void off(){

    }

    public void setVolume(int vol){

    }

    public void setCanal(int canal){

    }
}
