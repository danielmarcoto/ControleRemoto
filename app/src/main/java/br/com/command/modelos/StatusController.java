package br.com.command.modelos;

/**
 * Created by danielmarcoto on 18/11/15.
 */
public class StatusController {
    private static StatusController instance;

    private StatusController() {}

    public static StatusController getInstance(){
        if (instance == null)
            instance = new StatusController();
        return instance;
    }

    public boolean isGaragemAberta() {
        return garagemAberta;
    }

    public void setGaragemAberta(boolean garagemAberta) {
        this.garagemAberta = garagemAberta;
    }

    private boolean garagemAberta;
}
