package br.com.command.comandos;


import br.com.command.interfaces.Command;

/**
 * Created by Guilherme on 05/11/2015.
 */
public class MacroCommand implements Command {

    Command[] commands;

    public MacroCommand(Command[] commands) {
        this.commands = commands;
    }


    @Override
    public void execute() {
        for (int i = 0; i < commands.length; i++) {
            //commands[i].execute();
        }
    }
}
