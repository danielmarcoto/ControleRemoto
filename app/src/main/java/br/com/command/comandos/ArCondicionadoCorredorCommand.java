package br.com.command.comandos;

import br.com.command.interfaces.Command;
import br.com.command.modelos.ArCondicionadoCorredor;

/**
 * Created by danielmarcoto on 17/11/15.
 */
public class ArCondicionadoCorredorCommand implements Command {

    private ArCondicionadoCorredor arCondicionadoCorredor;

    public ArCondicionadoCorredorCommand(ArCondicionadoCorredor arCondicionadoCorredor) {
        this.arCondicionadoCorredor = arCondicionadoCorredor;
    }

    @Override
    public void execute() {
        if (arCondicionadoCorredor.isLigado()){
            arCondicionadoCorredor.desligar();
        } else {
            arCondicionadoCorredor.ligar();
        }
    }
}
