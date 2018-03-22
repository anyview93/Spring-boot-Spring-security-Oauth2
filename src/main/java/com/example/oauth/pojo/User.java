package com.example.oauth.pojo;

import java.io.Serializable;

/**
 * User实体类,对应user表
 */

public class User implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;

    private String userName;
    private String password;


    public User(int id, String userName, String password) {
        this.id = id;
        this.userName = userName;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
