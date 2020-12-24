package com.example.architectureexample;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "song_language_table")
public class NoteLanguage {
    @PrimaryKey
    private int noteLanguageId;

    @ForeignKey(entity = Note.class, parentColumns = "id", childColumns = "")
    private int id;

    @ForeignKey(entity = Language.class, parentColumns = "languageId", childColumns = "")
    private int languageId;

    public int getNoteLanguageId() {
        return noteLanguageId;
    }

    public int getId() {
        return id;
    }

    public int getLanguageId() {
        return languageId;
    }

    public void setNoteLanguageId(int noteLanguageId) {
        this.noteLanguageId = noteLanguageId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLanguageId(int languageId) {
        this.languageId = languageId;
    }
}
