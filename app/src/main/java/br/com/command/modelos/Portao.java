package br.com.command.modelos;

import android.util.Log;

import br.com.command.comandos.Status;

/**
 * Created by danielmarcoto on 16/11/15.
 */
public class Portao {

    private boolean estado;
    private Status s = Status.getInstance();
    private static Portao instance = null;

    private Portao(){
    }

    public static Portao getInstante(){
        if (instance == null){
            instance = new Portao();
        }
        return instance;
    }

    public boolean isEstado() {
        return estado;
    }

    public void abrir(){
        s.chamarServico("Abrir Portão", "Abrir o portão da garagem");
        estado = true;

        Log.i("Log", "Botão acionado on");
    }

    public void fechar(){
        s.chamarServico("Fechar Portão", "Fechar o portão da garagem");
        estado = false;

        Log.i("Log", "Botão acionado off");
    }
}
