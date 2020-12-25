package com.example.architectureexample.db.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "note_table")
public class Note {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") @SerializedName(value="id") private int id;
    @ColumnInfo(name = "title") @SerializedName(value = "title") private String title;
    @ColumnInfo(name = "description") @SerializedName(value = "description") private String description;
    @ColumnInfo(name = "priority") @SerializedName(value = "priority") private int priority;
    @ColumnInfo(name = "genre") @SerializedName(value = "genre") private String genre;
    @ColumnInfo(name = "group") @SerializedName(value = "group") private String group;
    @ColumnInfo(name = "musician") @SerializedName(value = "musician") private String musician;
    @ColumnInfo(name = "type_of_public") @SerializedName(value = "type_of_public") private String type_of_public;

    @ForeignKey(entity = Album.class, parentColumns = "albumId", childColumns = "")
    private int albumId;

    public Note(String title, String description, int priority, String genre, String group, String musician, String type_of_public) {
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.genre = genre;
        this.group = group;
        this.musician = musician;
        this.type_of_public = type_of_public;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public void setMusician(String musician) {
        this.musician = musician;
    }

    public void setType_of_public(String type_of_public) {
        this.type_of_public = type_of_public;
    }

    public String getGenre() {
        return genre;
    }

    public String getGroup() {
        return group;
    }

    public String getMusician() {
        return musician;
    }

    public String getType_of_public() {
        return type_of_public;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getPriority() {
        return priority;
    }

    public int getAlbumId() {
        return albumId;
    }
}
