package br.com.command.comandos;

import br.com.command.interfaces.Command;
import br.com.command.modelos.ArCondicionadoCorredor;
import br.com.command.modelos.ArCondicionadoSuite;

/**
 * Created by danielmarcoto on 17/11/15.
 */
public class ArCondicionadoSuiteCommand implements Command {

    private ArCondicionadoSuite arCondicionado;

    public ArCondicionadoSuiteCommand(ArCondicionadoSuite arCondicionado) {
        this.arCondicionado = arCondicionado;
    }

    @Override
    public void execute() {
        if (arCondicionado.isLigado()){
            arCondicionado.desligar();
        } else {
            arCondicionado.ligar();
        }
    }
}
