package com.example.estudentkrosno.ui.oceny;

public class OcenyModel {

    private int id_ucznia;
    private String imie_ucznia;
    private int ocena;

    private OcenyModel(int id_ucznia, String imie_ucznia, int ocena){
        this.id_ucznia = id_ucznia;
        this.imie_ucznia = imie_ucznia;
        this.ocena = ocena;
    }

    public int getId_ucznia() {
        return id_ucznia;
    }

    public void setId_ucznia(int id_ucznia) {
        this.id_ucznia = id_ucznia;
    }

    public String getImie_ucznia() {
        return imie_ucznia;
    }

    public void setImie_ucznia(String imie_ucznia) {
        this.imie_ucznia = imie_ucznia;
    }

    public int getOcena() {
        return ocena;
    }

    public void setOcena(int ocena) {
        this.ocena = ocena;
    }

}
