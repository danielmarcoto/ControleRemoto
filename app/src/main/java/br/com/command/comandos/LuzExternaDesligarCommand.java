package br.com.command.comandos;

import br.com.command.interfaces.Command;
import br.com.command.modelos.LuzExterna;

/**
 * Created by danielmarcoto on 17/11/15.
 */
public class LuzExternaDesligarCommand implements Command {

    private LuzExterna luzExterna;

    public LuzExternaDesligarCommand(LuzExterna luzExterna) {
        this.luzExterna = luzExterna;
    }

    @Override
    public void execute() {luzExterna.desligar();}
}
