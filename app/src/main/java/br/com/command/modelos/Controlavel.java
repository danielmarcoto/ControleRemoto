package br.com.command.modelos;

import br.com.command.util.ExternalService;
import br.com.command.util.OnStatusChangeListener;

/**
 * Created by danielmarcoto on 18/11/15.
 */
public abstract class Controlavel {
    protected OnStatusChangeListener onStatusChangeListener;
    protected ExternalService externalService;
    protected StatusController statusController;

    public Controlavel(){
        externalService = ExternalService.getInstance();
        statusController = StatusController.getInstance();
    }

    public void setOnStatusChangeListener(OnStatusChangeListener onStatusChangeListener) {
        this.onStatusChangeListener = onStatusChangeListener;
    }
}
