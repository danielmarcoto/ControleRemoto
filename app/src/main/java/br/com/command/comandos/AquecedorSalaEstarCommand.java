package br.com.command.comandos;

import br.com.command.interfaces.Command;
import br.com.command.modelos.AquecedorSalaEstar;
import br.com.command.modelos.AquecedorSuite;

/**
 * Created by danielmarcoto on 17/11/15.
 */
public class AquecedorSalaEstarCommand implements Command {

    private AquecedorSalaEstar aquecedor;

    public AquecedorSalaEstarCommand(AquecedorSalaEstar aquecedor) {
        this.aquecedor = aquecedor;
    }

    @Override
    public void execute() {
        if (aquecedor.isLigado()){
            aquecedor.desligar();
        } else {
            aquecedor.ligar();
        }
    }
}
