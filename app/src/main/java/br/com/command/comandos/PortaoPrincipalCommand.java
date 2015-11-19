package br.com.command.comandos;

import br.com.command.interfaces.Command;
import br.com.command.modelos.Portao;

/**
 * Created by danielmarcoto on 16/11/15.
 */
public class PortaoPrincipalCommand implements Command {

    private Portao portao;

    public PortaoPrincipalCommand(Portao portao) {
        this.portao = portao;
    }

    @Override
    public void execute()  {
        if(portao.isAberto()){
            portao.fechar();

        } else{
            try {
                portao.abrir();
            } catch (Exception ec){
                ec.printStackTrace();
            }
        }
    }
}
