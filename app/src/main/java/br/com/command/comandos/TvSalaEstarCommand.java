package br.com.command.comandos;

import br.com.command.interfaces.Command;
import br.com.command.modelos.TvSalaEstar;

/**
 * Created by danielmarcoto on 17/11/15.
 */
public class TvSalaEstarCommand implements Command {

    private TvSalaEstar tvSalaEstar;

    public TvSalaEstarCommand(TvSalaEstar tvSalaEstar) {
        this.tvSalaEstar = tvSalaEstar;
    }

    @Override
    public void execute() {
        if (tvSalaEstar.isLigado()){
            tvSalaEstar.desligar();
        } else {
            tvSalaEstar.ligar();
        }
    }
}
