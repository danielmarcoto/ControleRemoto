package br.com.command.interfaces;

/**
 * Created by danielmarcoto on 18/11/15.
 */
public interface ServiceStatus {
    void callbackIfSuccess();
    void callbackIfFail();
}
