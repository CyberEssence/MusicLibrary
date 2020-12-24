package com.example.architectureexample;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "public_of_genre_table")
public class PublicOfGenre {

    @PrimaryKey(autoGenerate = true)
    private int publicOfGenreId;

    @ForeignKey(entity = Public.class, parentColumns = "publicId", childColumns = "")
    private int publicId;

    @ForeignKey(entity = Genre.class, parentColumns = "publicId", childColumns = "")
    private int genreId;

    public PublicOfGenre(int publicOfGenreId, int publicId, int genreId) {
        this.publicOfGenreId = publicOfGenreId;
        this.publicId = publicId;
        this.genreId = genreId;
    }

    public void setPublicOfGenreId(int publicOfGenreId) {
        this.publicOfGenreId = publicOfGenreId;
    }

    public void setPublicId(int publicId) {
        this.publicId = publicId;
    }

    public void setGenreId(int genreId) {
        this.genreId = genreId;
    }

    public int getPublicOfGenreId() {
        return publicOfGenreId;
    }

    public int getPublicId() {
        return publicId;
    }

    public int getGenreId() {
        return genreId;
    }
}
