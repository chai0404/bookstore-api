package com.litshelf.litshelf_api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class LoginRequest {

    private String email;
    private String password;

    // ✅ REQUIRED (very important)
    public LoginRequest() {}

    public String getEmail() { return email; }
    public String getPassword() { return password; }

    public void setEmail(String email) { this.email = email; }
    public void setPassword(String password) { this.password = password; }
}