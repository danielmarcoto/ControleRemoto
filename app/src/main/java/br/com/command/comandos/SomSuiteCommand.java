package br.com.command.comandos;

import br.com.command.interfaces.Command;
import br.com.command.modelos.SomCozinha;
import br.com.command.modelos.SomSuite;

/**
 * Created by danielmarcoto on 17/11/15.
 */
public class SomSuiteCommand implements Command {

    private SomSuite som;

    public SomSuiteCommand(SomSuite som) {
        this.som = som;
    }

    @Override
    public void execute() {
        if (som.isLigado()){
            som.desligar();
        } else {
            som.ligar();
        }
    }
}
