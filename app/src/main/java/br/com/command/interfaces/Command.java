package br.com.command.interfaces;

/**
 * Created by Guilherme on 05/11/2015.
 */
public interface Command {

    public void execute();
    public void undo();
}
