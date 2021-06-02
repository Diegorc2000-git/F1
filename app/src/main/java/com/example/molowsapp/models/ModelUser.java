package com.example.molowsapp.models;

public class ModelUser {

    //use same name as in firebase database
    String nombre, email, search, telefono, imagen, cover, uid, onlineStatus, typingTo;
    boolean isBlocked = false;

    public ModelUser() {
    }

    public ModelUser(String nombre, String email, String search, String telefono, String imagen, String cover, String uid, String onlineStatus, String typingTo, boolean isBlocked) {
        this.nombre = nombre;
        this.email = email;
        this.search = search;
        this.telefono = telefono;
        this.imagen = imagen;
        this.cover = cover;
        this.uid = uid;
        this.onlineStatus = onlineStatus;
        this.typingTo = typingTo;
        this.isBlocked = isBlocked;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getOnlineStatus() {
        return onlineStatus;
    }

    public void setOnlineStatus(String onlineStatus) {
        this.onlineStatus = onlineStatus;
    }

    public String getTypingTo() {
        return typingTo;
    }

    public void setTypingTo(String typingTo) {
        this.typingTo = typingTo;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public void setBlocked(boolean blocked) {
        isBlocked = blocked;
    }
}

