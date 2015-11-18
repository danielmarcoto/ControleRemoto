package br.com.command.comandos;

import br.com.command.interfaces.Command;
import br.com.command.modelos.ArCondicionadoSalaEstar;

/**
 * Created by danielmarcoto on 17/11/15.
 */
public class ArCondicionadoSalaEstarCommand implements Command {
    private ArCondicionadoSalaEstar arCondicionado;

    public ArCondicionadoSalaEstarCommand(ArCondicionadoSalaEstar arCondicionado) {
        this.arCondicionado = arCondicionado;
    }

    @Override
    public void execute() {
        if (arCondicionado.isLigado()){
            arCondicionado.desligar();
        } else {
            arCondicionado.ligar();
        }
    }
}
