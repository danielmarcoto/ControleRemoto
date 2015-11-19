package br.com.command.comandos;

import br.com.command.interfaces.Command;
import br.com.command.modelos.AquecedorSuite;

/**
 * Created by danielmarcoto on 17/11/15.
 */
public class AquecedorSuiteDesligarCommand implements Command {

    private AquecedorSuite aquecedor;

    public AquecedorSuiteDesligarCommand(AquecedorSuite aquecedor) {
        this.aquecedor = aquecedor;
    }

    @Override
    public void execute() {aquecedor.desligar();}
}
