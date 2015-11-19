package br.com.command.comandos;

import br.com.command.interfaces.Command;
import br.com.command.modelos.ArCondicionadoSuite;

/**
 * Created by danielmarcoto on 17/11/15.
 */
public class ArCondicionadoSuiteDesligarCommand implements Command {

    private ArCondicionadoSuite arCondicionado;

    public ArCondicionadoSuiteDesligarCommand(ArCondicionadoSuite arCondicionado) {
        this.arCondicionado = arCondicionado;
    }

    @Override
    public void execute() {arCondicionado.desligar();}
}
