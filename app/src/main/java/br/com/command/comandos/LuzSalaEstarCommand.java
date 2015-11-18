package br.com.command.comandos;

import br.com.command.interfaces.Command;
import br.com.command.modelos.LuzSalaEstar;

/**
 * Created by danielmarcoto on 17/11/15.
 */
public class LuzSalaEstarCommand implements Command {

    private LuzSalaEstar luzSalaEstar;

    public LuzSalaEstarCommand(LuzSalaEstar luzSalaEstar) {
        this.luzSalaEstar = luzSalaEstar;
    }

    @Override
    public void execute() {
        if (luzSalaEstar.isLigada()) {
            luzSalaEstar.desligar();
        } else {
            luzSalaEstar.ligar();
        }
    }
}
