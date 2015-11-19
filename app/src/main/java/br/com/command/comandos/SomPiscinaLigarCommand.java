package br.com.command.comandos;

import br.com.command.interfaces.Command;
import br.com.command.modelos.SomPiscina;

/**
 * Created by danielmarcoto on 17/11/15.
 */
public class SomPiscinaLigarCommand implements Command {

    private SomPiscina som;

    public SomPiscinaLigarCommand(SomPiscina som) {
        this.som = som;
    }

    @Override
    public void execute() {som.ligar();}
}
