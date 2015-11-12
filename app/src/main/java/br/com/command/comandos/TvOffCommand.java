package br.com.command.comandos;


import br.com.command.interfaces.Command;
import br.com.command.modelos.TV;

/**
 * Created by Guilherme on 05/11/2015.
 */
public class TvOffCommand implements Command {
    TV tv;

    public TvOffCommand(TV tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.off();
    }

    @Override
    public void undo() {
        tv.on();
        tv.setCanal(5);
        tv.setVolume(9);
    }
}
