package br.com.command.comandos;

import br.com.command.interfaces.Command;
import br.com.command.modelos.PersianaSalaEstar;

/**
 * Created by danielmarcoto on 17/11/15.
 */
public class PersianaSalaEstarCommand implements Command {

    private PersianaSalaEstar persiana;

    public PersianaSalaEstarCommand(PersianaSalaEstar persiana) {
        this.persiana = persiana;
    }

    @Override
    public void execute() {
        if (persiana.isAberta()){
            persiana.fechar();
        } else{
            persiana.abrir();
        }
    }
}
