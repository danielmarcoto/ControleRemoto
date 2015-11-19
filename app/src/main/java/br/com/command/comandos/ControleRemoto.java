package br.com.command.comandos;


import br.com.command.interfaces.Command;

/**
 * Created by Guilherme on 05/11/2015.
 */
public class ControleRemoto {

    private final int totalCommands = 19;

    Command[] onCommands;
    Command[] offCommands;
    Command undoCommand;

    public ControleRemoto() {

        onCommands = new Command[totalCommands];
        offCommands = new Command[totalCommands];

        Command noCommand = new NoCommand();

        for (int i = 0; i < totalCommands; i++) {
            onCommands[i] = noCommand;
            offCommands[i] = noCommand;
        }
        undoCommand = noCommand;
    }

    public void setCommand(int slot, Command onCommand, Command offCommand) {
        onCommands[slot] = onCommand;
        offCommands[slot] = offCommand;
    }

    public void onButtonWasPushed(int slot) {
        onCommands[slot].execute();
        //undoCommand = onCommands[slot];
    }

    public void offButtonWasPushed(int slot) {
        offCommands[slot].execute();
        //undoCommand = offCommands[slot];
    }
    /*
    public void undoButtonWasPushed() {
        undoCommand.undo();
    }*/

    public Command getCommand(int slot) {
        return onCommands[slot];
    }

}

