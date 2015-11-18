package br.com.command.comandos;

import br.com.command.interfaces.Command;
import br.com.command.modelos.SomCozinha;
import br.com.command.modelos.SomSalaEstar;

/**
 * Created by danielmarcoto on 17/11/15.
 */
public class SomSalaEstarCommand implements Command {
    private SomSalaEstar som;

    public SomSalaEstarCommand(SomSalaEstar som) {
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
