package br.com.command.comandos;


import br.com.command.interfaces.Command;
import br.com.command.modelos.Light;

/**
 * Created by Guilherme on 05/11/2015.
 */
public class LightOffComand implements Command {
    Light light;

    public LightOffComand(Light light){
        this.light=light;
    }

    @Override
    public void execute() {
        light.off();
    }

    @Override
    public void undo() {
        light.on();
    }
}
