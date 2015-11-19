package br.com.command.comandos;

import br.com.command.interfaces.Command;
import br.com.command.modelos.Portao;

/**
 * Created by danielmarcoto on 18/11/15.
 */
public class PortaoFecharCommand implements Command {

    private Portao portao;

    public PortaoFecharCommand(Portao portao) {
        this.portao = portao;
    }

    @Override
    public void execute() {
        portao.fechar();
    }
}
