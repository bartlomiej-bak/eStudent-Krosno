package com.example.estudentkrosno.ui.oceny;

public class OcenaModel {

    private String przedmiot;
    private String ocena;

    private OcenaModel(){}

    private OcenaModel(String przedmiot, String ocena){
        this.przedmiot = przedmiot;
        this.ocena = ocena;
    }

    public String getPrzedmiot() {
        return przedmiot;
    }

    public String getOcena() {
        return ocena;
    }
}
