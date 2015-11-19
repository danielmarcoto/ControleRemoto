package br.com.command.comandos;

import br.com.command.interfaces.Command;
import br.com.command.modelos.ArCondicionadoCorredor;

/**
 * Created by danielmarcoto on 17/11/15.
 */
public class ArCondicionadoCorredorLigarCommand implements Command {

    private ArCondicionadoCorredor arCondicionadoCorredor;

    public ArCondicionadoCorredorLigarCommand(ArCondicionadoCorredor arCondicionadoCorredor) {
        this.arCondicionadoCorredor = arCondicionadoCorredor;
    }

    @Override
    public void execute() {arCondicionadoCorredor.ligar();}

}
