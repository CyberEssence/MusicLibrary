package com.example.architectureexample;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "language_table")
public class Language {
    @PrimaryKey
    private int languageId;

    private String title;

    public Language(int languageId, String title) {
        this.languageId = languageId;
        this.title = title;
    }

    public void setLanguageId(int languageId) {
        this.languageId = languageId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getLanguageId() {
        return languageId;
    }

    public String getTitle() {
        return title;
    }
}
