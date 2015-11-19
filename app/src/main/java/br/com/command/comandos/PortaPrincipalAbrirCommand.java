package br.com.command.comandos;

import br.com.command.interfaces.Command;
import br.com.command.modelos.Porta;

/**
 * Created by danielmarcoto on 17/11/15.
 */
public class PortaPrincipalAbrirCommand implements Command {

    Porta porta;

    public PortaPrincipalAbrirCommand(Porta porta){
        this.porta = porta;
    }

    @Override
    public void execute() {porta.abrir();}
}
