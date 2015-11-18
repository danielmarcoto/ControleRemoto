package br.com.command.comandos;

import br.com.command.interfaces.Command;
import br.com.command.modelos.Porta;

/**
 * Created by danielmarcoto on 17/11/15.
 */
public class PortaPrincipalCommand implements Command {

    Porta porta;

    public PortaPrincipalCommand(Porta porta){
        this.porta = porta;
    }

    @Override
    public void execute() {
        if (!porta.isAberta()) {
            porta.abrir();
        }  else {
            porta.fechar();
            porta.trancar();
        }
    }
}
