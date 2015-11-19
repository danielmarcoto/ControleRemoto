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
    public void execute()  {
        try {
            portao.abrir();
        } catch (Exception ec){
            ec.printStackTrace();
            }
    }
}
