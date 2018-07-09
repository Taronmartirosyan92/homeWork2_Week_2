package com.example.sargis.homeworkcardviewtar.models;

public class ImageModel {
    private String title;
    private String imageUrl;
    private String cibcom;

    public String getCibcom() {
        return cibcom;
    }

    public void setCibcom(String cibcom) {
        this.cibcom = cibcom;
    }

    public ImageModel(String title, String imageUrl) {
        this.title = title;
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

}
