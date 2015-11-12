package br.com.command.comandos;


import br.com.command.interfaces.Command;
import br.com.command.modelos.Light;

/**
 * Created by Guilherme on 05/11/2015.
 */
public class LightOnComand implements Command {

    Light light;

    public LightOnComand(Light light){
        this.light=light;
    }

    @Override
    public void execute() {
        light.on();
    }

    @Override
    public void undo() {
        light.off();
    }

}
