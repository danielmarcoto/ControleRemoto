package br.com.command.comandos;

import br.com.command.interfaces.Command;
import br.com.command.modelos.SomSalaEstar;

/**
 * Created by danielmarcoto on 17/11/15.
 */
public class SomSalaEstarDesligarCommand implements Command {
    private SomSalaEstar som;

    public SomSalaEstarDesligarCommand(SomSalaEstar som) {
        this.som = som;
    }

    @Override
    public void execute() {som.desligar();}
}
