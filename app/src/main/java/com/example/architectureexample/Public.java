package com.example.architectureexample;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "public_table")
public class Public {

    @PrimaryKey(autoGenerate = true)
    private int publicId;

    private String type;

    private int averageAge;

    @ForeignKey(entity = TypesOfPublic.class, parentColumns = "typesOfPublicId", childColumns = "")
    private int typeOfPublicId;

    public Public(int publicId, String type, int averageAge, int typeOfPublicId) {
        this.publicId = publicId;
        this.type = type;
        this.averageAge = averageAge;
        this.typeOfPublicId = typeOfPublicId;
    }

    public void setPublicId(int publicId) {
        this.publicId = publicId;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setAverageAge(int averageAge) {
        this.averageAge = averageAge;
    }

    public void setTypeOfPublicId(int typeOfPublicId) {
        this.typeOfPublicId = typeOfPublicId;
    }

    public int getPublicId() {
        return publicId;
    }

    public String getType() {
        return type;
    }

    public int getAverageAge() {
        return averageAge;
    }

    public int getTypeOfPublicId() {
        return typeOfPublicId;
    }
}
