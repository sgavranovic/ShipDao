package com.example.project.domain;

public class Ship {
    private String id;
    private String ime;
    private String maticnaLuka;

    public Ship(String id, String ime, String maticnaLuka) {
        this.id = id;
        this.ime = ime;
        this.maticnaLuka = maticnaLuka;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getMaticnaLuka() {
        return maticnaLuka;
    }

    public void setMaticnaLuka(String maticnaLuka) {
        this.maticnaLuka = maticnaLuka;
    }
}
