package br.com.command.comandos;

import br.com.command.interfaces.Command;
import br.com.command.modelos.LuzSuite;

/**
 * Created by danielmarcoto on 17/11/15.
 */
public class LuzSuiteCommand implements Command {

    private LuzSuite luzSuite;

    public LuzSuiteCommand(LuzSuite luzSuite) {
        this.luzSuite = luzSuite;
    }

    @Override
    public void execute() {
        if (luzSuite.isLigada()) {
            luzSuite.desligar();
        } else {
            luzSuite.ligar();
        }
    }
}
