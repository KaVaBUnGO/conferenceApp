package com.conference.domain;

import org.hibernate.validator.constraints.NotEmpty;

public class UserCreateForm {

    @NotEmpty
    private String name = "";

    @NotEmpty
    private String password = "";

    @NotEmpty
    private String passwordRepeated = "";

    @NotEmpty
    private String email = "";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordRepeated() {
        return passwordRepeated;
    }

    public void setPasswordRepeated(String passwordRepeated) {
        this.passwordRepeated = passwordRepeated;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
