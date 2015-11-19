package br.com.command.comandos;

import br.com.command.interfaces.Command;
import br.com.command.modelos.PersianaSuite;

/**
 * Created by danielmarcoto on 17/11/15.
 */
public class PersianaSuiteFecharCommand implements Command {
    private PersianaSuite persiana;

    public PersianaSuiteFecharCommand(PersianaSuite persiana) {
        this.persiana = persiana;
    }

    @Override
    public void execute() {persiana.fechar();}
}
