package com.example.architectureexample;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "genre_table")
public class Genre {

    @PrimaryKey(autoGenerate = true)
    private int genreId;

    private String title;

    private String style;

    public Genre(int genreId, String title, String style) {
        this.genreId = genreId;
        this.title = title;
        this.style = style;
    }

    public void setGenreId(int genreId) {
        this.genreId = genreId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public int getGenreId() {
        return genreId;
    }

    public String getTitle() {
        return title;
    }

    public String getStyle() {
        return style;
    }
}
