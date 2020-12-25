package com.example.architectureexample.db.entities;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "group_table")
public class Group {

    @PrimaryKey(autoGenerate = true)
    private int groupId;

    @ForeignKey(entity = Genre.class, parentColumns = "genreID", childColumns = "")
    private int genreId;

    private String titleOfGroup;

    private int yearOfFounded;

    private int numberOfMemebers;

    public Group(int groupId, int genreId, String titleOfGroup, int yearOfFounded, int numberOfMemebers) {
        this.groupId = groupId;
        this.genreId = genreId;
        this.titleOfGroup = titleOfGroup;
        this.yearOfFounded = yearOfFounded;
        this.numberOfMemebers = numberOfMemebers;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public void setGenreId(int genreId) {
        this.genreId = genreId;
    }

    public void setTitleOfGroup(String titleOfGroup) {
        this.titleOfGroup = titleOfGroup;
    }

    public void setYearOfFounded(int yearOfFounded) {
        this.yearOfFounded = yearOfFounded;
    }

    public void setNumberOfMemebers(int numberOfMemebers) {
        this.numberOfMemebers = numberOfMemebers;
    }

    public int getGroupId() {
        return groupId;
    }

    public int getGenreId() {
        return genreId;
    }

    public String getTitleOfGroup() {
        return titleOfGroup;
    }

    public int getYearOfFounded() {
        return yearOfFounded;
    }

    public int getNumberOfMemebers() {
        return numberOfMemebers;
    }
}
