package br.com.command.comandos;

import br.com.command.interfaces.Command;
import br.com.command.modelos.SomSuite;

/**
 * Created by danielmarcoto on 17/11/15.
 */
public class SomSuiteLigarCommand implements Command {

    private SomSuite som;

    public SomSuiteLigarCommand(SomSuite som) {
        this.som = som;
    }

    @Override
    public void execute() {som.ligar();}
}
