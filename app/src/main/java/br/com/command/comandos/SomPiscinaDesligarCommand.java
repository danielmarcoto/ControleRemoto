package br.com.command.comandos;

import br.com.command.interfaces.Command;
import br.com.command.modelos.SomPiscina;

/**
 * Created by danielmarcoto on 17/11/15.
 */
public class SomPiscinaDesligarCommand implements Command {

    private SomPiscina som;

    public SomPiscinaDesligarCommand(SomPiscina som) {
        this.som = som;
    }

    @Override
    public void execute() {som.desligar();}
}
