package br.com.command.modelos;


import br.com.command.comandos.Status;

/**
 * Created by Guilherme on 05/11/2015.
 */
public class Light {
    Status s = Status.getInstance();

    public void on(){
        s.addMensagem("Luz acesa");
    }

    public void off(){
        s.addMensagem("Luz apagada");
    }

}
