package com.example.wallpaperapp;

public class WallpaperModel {
    private int id;
    private String mediumURL,originalURL;

    public WallpaperModel() {
    }

    public WallpaperModel(int id,String mediumURL,String originalURL) {
        this.id = id;
        this.mediumURL = mediumURL;
        this.originalURL = originalURL;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMediumURL() {
        return mediumURL;
    }

    public void setMediumURL(String mediumURL) {
        this.mediumURL = mediumURL;
    }

    public String getOriginalURL() {
        return originalURL;
    }

    public void setOriginalURL(String originalURL) {
        this.originalURL = originalURL;
    }
}
