package br.com.command.comandos;

import br.com.command.interfaces.Command;
import br.com.command.modelos.SomCozinha;

/**
 * Created by danielmarcoto on 17/11/15.
 */
public class SomCozinhaCommand implements Command {

    private SomCozinha som;

    public SomCozinhaCommand(SomCozinha som) {
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
