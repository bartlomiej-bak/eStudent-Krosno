package com.example.estudentkrosno.ui.aktualnosci;

public class Post{

    private String title;
    private String desc;
    private int photo;

    public Post(String title, String desc, int photo) {
        this.title = title;
        this.desc = desc;
        this.photo = photo;
    }

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }

    public int getPhoto() {
        return photo;
    }
}
