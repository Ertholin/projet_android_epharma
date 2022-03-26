package com.example.epharma_inf1030_h22_g3.models;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "user")
public class User {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "user_id")
    @NonNull
    private Long userId;

    @ColumnInfo(name="username")
    @NonNull
    private String username;
    @ColumnInfo(name="email")
    @NonNull
    private String email;
    @ColumnInfo(name="first_name")
    @NonNull
    private String firstName;
    @ColumnInfo(name="last_name")
    @NonNull
    private String lastName;
    @ColumnInfo(name="password")
    @NonNull
    private String password;
    @ColumnInfo(name="password_salt")
    @NonNull
    private String passwordSalt;
    public User() {
    }

    @NonNull
    public Long getUserId() {
        return userId;
    }

    @NonNull
    public String getUsername() {
        return username;
    }

    @NonNull
    public String getEmail() {
        return email;
    }

    @NonNull
    public String getFirstName() {
        return firstName;
    }

    @NonNull
    public String getLastName() {
        return lastName;
    }

    @NonNull
    public String getPassword() {
        return password;
    }

    @NonNull
    public String getPasswordSalt() {
        return passwordSalt;
    }

    public void setUserId(@NonNull Long userId) {
        this.userId = userId;
    }

    public void setUsername(@NonNull String username) {
        this.username = username;
    }

    public void setEmail(@NonNull String email) {
        this.email = email;
    }

    public void setFirstName(@NonNull String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(@NonNull String lastName) {
        this.lastName = lastName;
    }

    public void setPassword(@NonNull String password) {
        this.password = password;
    }

    public void setPasswordSalt(@NonNull String passwordSalt) {
        this.passwordSalt = passwordSalt;
    }
}
