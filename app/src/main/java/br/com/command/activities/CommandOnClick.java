package br.com.command.activities;

import android.view.View;
import android.widget.ToggleButton;

import br.com.command.comandos.ControleRemoto;
import br.com.command.interfaces.Command;

/**
 * Created by danielmarcoto on 16/11/15.
 */
public class CommandOnClick implements View.OnClickListener {

    private int slot;
    private ControleRemoto controleRemoto;

    public CommandOnClick(int slot, ControleRemoto controleRemoto){
        this.slot = slot;
        this.controleRemoto = controleRemoto;
    }

    @Override
    public void onClick(View view) {
        ToggleButton toggleButton = (ToggleButton)view;

        if (toggleButton.isChecked()){
            controleRemoto.onButtonWasPushed(slot);
        } else {
            controleRemoto.offButtonWasPushed(slot);
        }
    }
}
