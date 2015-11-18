package br.com.command.comandos;

import br.com.command.interfaces.Command;
import br.com.command.modelos.Garagem;

/**
 * Created by danielmarcoto on 17/11/15.
 */
public class GaragemCommand implements Command {

    private Garagem garagem;

    public GaragemCommand(Garagem garagem) {
        this.garagem = garagem;
    }

    @Override
    public void execute() {
        if (garagem.isAberta()) {
            garagem.fechar();
        } else {
            garagem.abrir();
        }
    }
}
