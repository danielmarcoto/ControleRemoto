package br.com.command.comandos;

import br.com.command.interfaces.Command;
import br.com.command.modelos.LuzExterna;

/**
 * Created by danielmarcoto on 17/11/15.
 */
public class LuzExternaCommand implements Command {

    private LuzExterna luzExterna;

    public LuzExternaCommand(LuzExterna luzExterna) {
        this.luzExterna = luzExterna;
    }

    @Override
    public void execute() {
        if (luzExterna.isLigada()) {
            luzExterna.desligar();
        } else {
            luzExterna.ligar();
        }
    }
}
