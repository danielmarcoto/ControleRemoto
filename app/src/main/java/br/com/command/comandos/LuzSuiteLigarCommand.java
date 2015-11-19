package br.com.command.comandos;

import br.com.command.interfaces.Command;
import br.com.command.modelos.LuzSuite;

/**
 * Created by danielmarcoto on 17/11/15.
 */
public class LuzSuiteLigarCommand implements Command {

    private LuzSuite luzSuite;

    public LuzSuiteLigarCommand(LuzSuite luzSuite) {
        this.luzSuite = luzSuite;
    }

    @Override
    public void execute() {luzSuite.ligar();}
}
