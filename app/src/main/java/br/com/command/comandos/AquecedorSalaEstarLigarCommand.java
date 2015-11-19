package br.com.command.comandos;

import br.com.command.interfaces.Command;
import br.com.command.modelos.AquecedorSalaEstar;

/**
 * Created by danielmarcoto on 17/11/15.
 */
public class AquecedorSalaEstarLigarCommand implements Command {

    private AquecedorSalaEstar aquecedor;

    public AquecedorSalaEstarLigarCommand(AquecedorSalaEstar aquecedor) {
        this.aquecedor = aquecedor;
    }

    @Override
    public void execute() {aquecedor.ligar();}
}
