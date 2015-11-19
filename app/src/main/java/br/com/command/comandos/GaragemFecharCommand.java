package br.com.command.comandos;

import br.com.command.interfaces.Command;
import br.com.command.modelos.Garagem;

/**
 * Created by danielmarcoto on 18/11/15.
 */
public class GaragemFecharCommand implements Command {

    private Garagem garagem;

    public GaragemFecharCommand(Garagem garagem) {
        this.garagem = garagem;
    }

    @Override
    public void execute() {
        garagem.fechar();
    }
}
