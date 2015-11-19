package br.com.command.modelos;

/**
 * Created by danielmarcoto on 18/11/15.
 */
public class StatusController {
    private static StatusController instance;

    private StatusController() {
    }

    public static StatusController getInstance() {
        if (instance == null)
            instance = new StatusController();
        return instance;
    }

    private boolean garagemAberta;
    private boolean portaoAberto;
    private boolean portaAberta;
    private boolean portaTrancada;

    private boolean luzExternaLigada;
    private boolean luzSalaEstarLigada;
    private boolean luzSuiteLigada;

    private boolean persianaSalaEstarAberta;
    private boolean persianaSuiteAberta;

    public boolean isLuzExternaLigada() {
        return luzExternaLigada;
    }

    public void setLuzExternaLigada(boolean luzExternaLigada) {
        this.luzExternaLigada = luzExternaLigada;
    }

    public boolean isGaragemAberta() {
        return garagemAberta;
    }

    public void setGaragemAberta(boolean garagemAberta) {
        this.garagemAberta = garagemAberta;
    }

    public boolean isPortaoAberto() {
        return portaoAberto;
    }

    public void setPortaoAberto(boolean portaoAberto) {
        this.portaoAberto = portaoAberto;
    }

    public boolean isLuzSalaEstarLigada() {
        return luzSalaEstarLigada;
    }

    public void setLuzSalaEstarLigada(boolean luzSalaEstarLigada) {
        this.luzSalaEstarLigada = luzSalaEstarLigada;
    }

    public boolean isLuzSuiteLigada() {
        return luzSuiteLigada;
    }

    public void setLuzSuiteLigada(boolean luzSuiteLigada) {
        this.luzSuiteLigada = luzSuiteLigada;
    }

    public boolean isPortaAberta() {
        return portaAberta;
    }

    public void setPortaAberta(boolean portaAberta) {
        this.portaAberta = portaAberta;
    }

    public boolean isPortaTrancada() {
        return portaTrancada;
    }

    public void setPortaTrancada(boolean portaTrancada) {
        this.portaTrancada = portaTrancada;
    }

    public boolean isPersianaSalaEstarAberta() {
        return persianaSalaEstarAberta;
    }

    public void setPersianaSalaEstarAberta(boolean persianaSalaEstarAberta) {
        this.persianaSalaEstarAberta = persianaSalaEstarAberta;
    }

    public boolean isPersianaSuiteAberta() {
        return persianaSuiteAberta;
    }

    public void setPersianaSuiteAberta(boolean persianaSuiteAberta) {
        this.persianaSuiteAberta = persianaSuiteAberta;
    }
}
