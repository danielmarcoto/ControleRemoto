package br.com.command.modelos;


import br.com.command.comandos.Status;

/**
 * Created by Guilherme on 05/11/2015.
 */
public class GarageDoor {
    Status s = Status.getInstance();


    public void open(){
        s.addMensagem("Porta da garagem aberta");
    }

    public void close(){
        s.addMensagem("Porta da garagem fechada");
    }
}
