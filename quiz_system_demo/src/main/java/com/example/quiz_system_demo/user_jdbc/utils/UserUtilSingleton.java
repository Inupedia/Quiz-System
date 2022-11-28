package com.example.quiz_system_demo.user_jdbc.utils;

public class UserUtilSingleton {
    private static UserUtilSingleton instance = null;
    private UserUtil userUtil;

    private UserUtilSingleton() {
        userUtil = new UserUtil();
    }

    public static UserUtilSingleton getInstance() {
        if (instance == null) {
            instance = new UserUtilSingleton();
        }
        return instance;
    }

    public UserUtil getUserUtil() {
        return userUtil;
    }
}
