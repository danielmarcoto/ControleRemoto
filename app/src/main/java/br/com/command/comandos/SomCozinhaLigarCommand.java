package br.com.command.comandos;

import br.com.command.interfaces.Command;
import br.com.command.modelos.SomCozinha;

/**
 * Created by danielmarcoto on 17/11/15.
 */
public class SomCozinhaLigarCommand implements Command {

    private SomCozinha som;

    public SomCozinhaLigarCommand(SomCozinha som) {
        this.som = som;
    }

    @Override
    public void execute() {som.ligar();}
}
