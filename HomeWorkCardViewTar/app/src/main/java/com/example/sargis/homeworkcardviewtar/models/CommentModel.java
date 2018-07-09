package com.example.sargis.homeworkcardviewtar.models;

public class CommentModel {
    private String ImageUrl;
    private String commText;
    private String commTitle;


    public CommentModel(String imageUrl, String commText, String commTitle) {
        ImageUrl = imageUrl;
        this.commText = commText;
        this.commTitle = commTitle;
    }

    public String getCommTitle() {
        return commTitle;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public String getCommText() {
        return commText;
    }


}
