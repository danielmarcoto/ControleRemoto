package br.com.command.comandos;


import br.com.command.interfaces.Command;
import br.com.command.modelos.GarageDoor;

/**
 * Created by Guilherme on 05/11/2015.
 */
public class GarageDoorOpenCommand implements Command {
    GarageDoor garage;

    public GarageDoorOpenCommand(GarageDoor garage){
        this.garage=garage;
    }

    @Override
    public void execute() {
        garage.open();
    }

    @Override
    public void undo() {
        garage.open();
    }
}
