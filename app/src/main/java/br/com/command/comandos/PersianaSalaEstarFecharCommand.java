package br.com.command.comandos;

import br.com.command.interfaces.Command;
import br.com.command.modelos.PersianaSalaEstar;

/**
 * Created by danielmarcoto on 17/11/15.
 */
public class PersianaSalaEstarFecharCommand implements Command {

    private PersianaSalaEstar persiana;

    public PersianaSalaEstarFecharCommand(PersianaSalaEstar persiana) {
        this.persiana = persiana;
    }

    @Override
    public void execute() {persiana.fechar();}
}
