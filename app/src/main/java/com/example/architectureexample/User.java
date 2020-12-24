package com.example.architectureexample;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "users_table")
public class User {
    @PrimaryKey(autoGenerate = true)
    private int id;

    private String nameOfUser;

    private String email;

    private String login;

    private String pass;

    public User(int id, String nameOfUser, String email, String login, String pass) {
        this.id = id;
        this.nameOfUser = nameOfUser;
        this.email = email;
        this.login = login;
        this.pass = pass;
    }

    public int getId() {
        return id;
    }

    public String getNameOfUser() {
        return nameOfUser;
    }

    public String getEmail() {
        return email;
    }

    public String getLogin() {
        return login;
    }

    public String getPass() {
        return pass;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNameOfUser(String nameOfUser) {
        this.nameOfUser = nameOfUser;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
