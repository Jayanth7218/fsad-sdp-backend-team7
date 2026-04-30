package com.klef.fsad.springbootbackendproject.dto;

public class AuthRequestDTO 
{
    private String username;   // ✅ only this
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}