package com.example.estudentkrosno.ui.aktualnosci;

public class AktualnosciModel {

    private String uzytkownik;
    private String zawartosc;
    private String data;

    private AktualnosciModel(){}

    private AktualnosciModel(String uzytkownik, String zawartosc, String data){
        this.uzytkownik = uzytkownik;
        this.zawartosc = zawartosc;
        this.data = data;
    }

    public String getUzytkownik() {
        return uzytkownik;
    }

    public String getZawartosc() {
        return zawartosc;
    }

    public String getData() {
        return data;
    }
}
