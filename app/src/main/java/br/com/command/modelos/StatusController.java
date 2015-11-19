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

    private boolean aquecedorCorredorLigado;
    private boolean aquecedorSalaEstarLigado;
    private boolean aquecedorSuiteLigado;

    private boolean arCondicionadoCorredorLigado;
    private boolean arCondicionadoSalaEstarLigado;
    private boolean arCondicionadoSuiteLigado;

    private boolean somCozinha;
    private boolean somPiscina;
    private boolean somSalaEstar;
    private boolean somSuite;
    private boolean tvSalaEstar;


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

    public boolean isAquecedorCorredorLigado() {
        return aquecedorCorredorLigado;
    }

    public void setAquecedorCorredorLigado(boolean aquecedorCorredorLigado) {
        this.aquecedorCorredorLigado = aquecedorCorredorLigado;
    }

    public boolean isAquecedorSalaEstarLigado() {
        return aquecedorSalaEstarLigado;
    }

    public void setAquecedorSalaEstarLigado(boolean aquecedorSalaEstarLigado) {
        this.aquecedorSalaEstarLigado = aquecedorSalaEstarLigado;
    }

    public boolean isAquecedorSuiteLigado() {
        return aquecedorSuiteLigado;
    }

    public void setAquecedorSuiteLigado(boolean aquecedorSuiteLigado) {
        this.aquecedorSuiteLigado = aquecedorSuiteLigado;
    }

    public boolean isArCondicionadoSuiteLigado() {
        return arCondicionadoSuiteLigado;
    }

    public void setArCondicionadoSuiteLigado(boolean arCondicionadoSuiteLigado) {
        this.arCondicionadoSuiteLigado = arCondicionadoSuiteLigado;
    }

    public boolean isArCondicionadoCorredorLigado() {
        return arCondicionadoCorredorLigado;
    }

    public void setArCondicionadoCorredorLigado(boolean arCondicionadoCorredorLigado) {
        this.arCondicionadoCorredorLigado = arCondicionadoCorredorLigado;
    }

    public boolean isArCondicionadoSalaEstarLigado() {
        return arCondicionadoSalaEstarLigado;
    }

    public void setArCondicionadoSalaEstarLigado(boolean arCondicionadoSalaEstarLigado) {
        this.arCondicionadoSalaEstarLigado = arCondicionadoSalaEstarLigado;
    }

    public boolean isSomCozinha() {
        return somCozinha;
    }

    public void setSomCozinha(boolean somCozinha) {
        this.somCozinha = somCozinha;
    }

    public boolean isSomPiscina() {
        return somPiscina;
    }

    public void setSomPiscina(boolean somPiscina) {
        this.somPiscina = somPiscina;
    }

    public boolean isSomSalaEstar() {
        return somSalaEstar;
    }

    public void setSomSalaEstar(boolean somSalaEstar) {
        this.somSalaEstar = somSalaEstar;
    }

    public boolean isSomSuite() {
        return somSuite;
    }

    public void setSomSuite(boolean somSuite) {
        this.somSuite = somSuite;
    }

    public boolean isTvSalaEstar() {
        return tvSalaEstar;
    }

    public void setTvSalaEstar(boolean tvSalaEstar) {
        this.tvSalaEstar = tvSalaEstar;
    }
}
