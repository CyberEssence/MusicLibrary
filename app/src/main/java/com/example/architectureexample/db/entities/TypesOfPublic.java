package com.example.architectureexample.db.entities;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "types_of_public_table")
public class TypesOfPublic {

    @PrimaryKey(autoGenerate = true)
    private int typesOfPublicId;

    private String title;

    public TypesOfPublic(String title) {
        this.title = title;
    }

    @Ignore
    public TypesOfPublic(int typesOfPublicId, String title) {
        this.typesOfPublicId = typesOfPublicId;
        this.title = title;
    }

    public void setTypesOfPublicId(int typesOfPublicId) {
        this.typesOfPublicId = typesOfPublicId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getTypesOfPublicId() {
        return typesOfPublicId;
    }

    public String getTitle() {
        return title;
    }
}
