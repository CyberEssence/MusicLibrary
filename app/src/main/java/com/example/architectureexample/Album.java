package com.example.architectureexample;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "album_table")
public class Album {

    @PrimaryKey(autoGenerate = true)
    private int albumId;

    @ForeignKey(entity = Group.class, parentColumns = "groupId", childColumns = "")
    private int groupId;

    private String albumTitle;

    private int yearOfIssue;

    private int numberOfSongsInAlbum;

    public Album(int albumId, int groupId, String albumTitle, int yearOfIssue, int numberOfSongsInAlbum) {
        this.albumId = albumId;
        this.groupId = groupId;
        this.albumTitle = albumTitle;
        this.yearOfIssue = yearOfIssue;
        this.numberOfSongsInAlbum = numberOfSongsInAlbum;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public void setAlbumTitle(String albumTitle) {
        this.albumTitle = albumTitle;
    }

    public void setYearOfIssue(int yearOfIssue) {
        this.yearOfIssue = yearOfIssue;
    }

    public void setNumberOfSongsInAlbum(int numberOfSongsInAlbum) {
        this.numberOfSongsInAlbum = numberOfSongsInAlbum;
    }

    public int getAlbumId() {
        return albumId;
    }

    public int getGroupId() {
        return groupId;
    }

    public String getAlbumTitle() {
        return albumTitle;
    }

    public int getYearOfIssue() {
        return yearOfIssue;
    }

    public int getNumberOfSongsInAlbum() {
        return numberOfSongsInAlbum;
    }
}
