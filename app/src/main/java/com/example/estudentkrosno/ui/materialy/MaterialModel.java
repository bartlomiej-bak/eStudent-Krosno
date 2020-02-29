package com.example.estudentkrosno.ui.materialy;

public class MaterialModel {

    private String nazwa;
    private String sciezka;

    private MaterialModel(){}

    private MaterialModel(String nazwa, String sciezka){
        this.nazwa = nazwa;
        this.sciezka = sciezka;
    }

    public String getNazwa() {
        return nazwa;
    }

    public String getSciezka() {
        return sciezka;
    }
}
