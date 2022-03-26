package com.example.epharma_inf1030_h22_g3.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.epharma_inf1030_h22_g3.models.User;

import java.util.List;

@Dao
public interface UserDAO {

    @Query("SELECT * FROM user")
    List<User> all();

    @Query("SELECT * FROM user WHERE user_id IN (:findUserId)")
    User findById(Long findUserId);

    @Query("SELECT * FROM user WHERE username IN (:username)")
    User findByUserName(String username);

    @Insert
    void insertALL(User...users);

    @Delete
    void deleteUser(User user);


}
