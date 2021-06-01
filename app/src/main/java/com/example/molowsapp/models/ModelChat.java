package com.example.molowsapp.models;

public class ModelChat {
    String mensaje, recibido, enviado, timestamp;
    boolean isSeen;

    public ModelChat() {
    }

    public ModelChat(String mensaje, String recibido, String enviado, String timestamp, boolean isSeen) {
        this.mensaje = mensaje;
        this.recibido = recibido;
        this.enviado = enviado;
        this.timestamp = timestamp;
        this.isSeen = isSeen;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getRecibido() {
        return recibido;
    }

    public void setRecibido(String recibido) {
        this.recibido = recibido;
    }

    public String getEnviado() {
        return enviado;
    }

    public void setEnviado(String enviado) {
        this.enviado = enviado;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public boolean isSeen() {
        return isSeen;
    }

    public void setSeen(boolean seen) {
        isSeen = seen;
    }
}
