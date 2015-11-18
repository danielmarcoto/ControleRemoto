package br.com.command.activities;

import android.view.View;

import br.com.command.interfaces.Command;

/**
 * Created by danielmarcoto on 16/11/15.
 */
public class CommandOnClick implements View.OnClickListener {
    Command command;

    public CommandOnClick(Command command){
        this.command = command;
    }

    @Override
    public void onClick(View view) {
        command.execute();
    }
}
