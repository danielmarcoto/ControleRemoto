package br.com.command.comandos;


import br.com.command.interfaces.Command;
import br.com.command.modelos.Stereo;

/**
 * Created by Guilherme on 05/11/2015.
 */
public class StereoOffCommand implements Command {

    Stereo stereo;

    public StereoOffCommand(Stereo stero) {
        this.stereo = stero;
    }

    @Override
    public void execute() {
        stereo.off();
    }

    @Override
    public void undo() {
        stereo.on();
        stereo.setCD();
        stereo.setVolume(11);
    }
}
