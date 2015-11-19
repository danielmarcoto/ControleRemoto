package br.com.command.comandos;

import br.com.command.interfaces.Command;
import br.com.command.modelos.ArCondicionadoSalaEstar;

/**
 * Created by danielmarcoto on 17/11/15.
 */
public class ArCondicionadoSalaEstarLigarCommand implements Command {
    private ArCondicionadoSalaEstar arCondicionado;

    public ArCondicionadoSalaEstarLigarCommand(ArCondicionadoSalaEstar arCondicionado) {
        this.arCondicionado = arCondicionado;
    }

    @Override
    public void execute() {arCondicionado.ligar();}
}
