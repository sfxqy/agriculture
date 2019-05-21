package com.wisdom.agriculture.comment;

import lombok.Data;

/**
 * @author SFX
 * 用户Bean
 */

@Data
public class User {

    private static Integer id;

    private static String username;

    private static String password;

    public User() {
    }

    public static void setUser(Integer id,String username,String password){
        id=id;
        username=username;
        password=password;
    }

    public static Integer getId() {
        return id;
    }

    public static void setId(Integer id) {
        User.id = id;
    }

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        User.username = username;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        User.password = password;
    }
}
