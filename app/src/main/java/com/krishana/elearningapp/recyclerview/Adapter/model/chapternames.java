package com.krishana.elearningapp.recyclerview.Adapter.model;

public class chapternames {
    String chaptername;
    String Description;
    Integer ImageUrl;

    public chapternames(String chaptername, String description, Integer imageUrl) {
        this.chaptername = chaptername;
        Description = description;
        ImageUrl = imageUrl;
    }

    public String getChaptername() {
        return chaptername;
    }

    public void setChaptername(String chaptername) {
        this.chaptername = chaptername;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Integer getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(Integer imageUrl) {
        ImageUrl = imageUrl;
    }
}
