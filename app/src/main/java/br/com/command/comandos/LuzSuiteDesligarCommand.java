package br.com.command.comandos;

import br.com.command.interfaces.Command;
import br.com.command.modelos.LuzSuite;

/**
 * Created by danielmarcoto on 17/11/15.
 */
public class LuzSuiteDesligarCommand implements Command {

    private LuzSuite luzSuite;

    public LuzSuiteDesligarCommand(LuzSuite luzSuite) {
        this.luzSuite = luzSuite;
    }

    @Override
    public void execute() {luzSuite.desligar();}
}
