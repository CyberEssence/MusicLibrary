package com.example.architectureexample.db.entities;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "musician_table")
public class Musician {

    @PrimaryKey
    private int musicianId;

    @ForeignKey(entity = Group.class, parentColumns = "groupId", childColumns = "")
    private int groupId;

    private String pseudonim;

    private boolean isKnownName;

    private String surname;

    private String name;

    private String patronymic;

    public Musician(int musicianId, int groupId, String pseudonim, boolean isKnownName, String surname, String name, String patronymic) {
        this.musicianId = musicianId;
        this.groupId = groupId;
        this.pseudonim = pseudonim;
        this.isKnownName = isKnownName;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
    }

    public void setMusicianId(int musicianId) {
        this.musicianId = musicianId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public void setPseudonim(String pseudonim) {
        this.pseudonim = pseudonim;
    }

    public void setKnownName(boolean knownName) {
        isKnownName = knownName;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public int getMusicianId() {
        return musicianId;
    }

    public int getGroupId() {
        return groupId;
    }

    public String getPseudonim() {
        return pseudonim;
    }

    public boolean isKnownName() {
        return isKnownName;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getPatronymic() {
        return patronymic;
    }
}
