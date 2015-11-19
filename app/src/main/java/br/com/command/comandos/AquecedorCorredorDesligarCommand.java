package br.com.command.comandos;

import br.com.command.interfaces.Command;
import br.com.command.modelos.AquecedorCorredor;

/**
 * Created by danielmarcoto on 17/11/15.
 */
public class AquecedorCorredorDesligarCommand implements Command {

    private AquecedorCorredor aquecedor;

    public AquecedorCorredorDesligarCommand(AquecedorCorredor aquecedor) {
        this.aquecedor = aquecedor;
    }

    @Override
    public void execute() {aquecedor.desligar();}
}
