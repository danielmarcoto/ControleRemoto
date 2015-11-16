package br.com.command.comandos;

import br.com.command.interfaces.Command;
import br.com.command.modelos.Portao;

/**
 * Created by danielmarcoto on 16/11/15.
 */
public class PortaoPrincipalAbrirCommand implements Command {

    private Portao portao;

    public PortaoPrincipalAbrirCommand(Portao portao) {
        this.portao = portao;
    }

    @Override
    public void execute() {
        if(portao.isEstado()){
            portao.fechar();

        } else{
            portao.abrir();
        }
    }

    @Override
    public void undo() {
        portao.fechar();
    }
}
