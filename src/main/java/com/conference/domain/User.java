package com.conference.domain;

import javax.annotation.Generated;
import javax.persistence.*;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "password", nullable = false)
    private String password;

    /*
    @Column(name = "role", nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;
    */
    @ManyToMany
    @JoinTable(
            name = "user_presentation",
            joinColumns = {@JoinColumn(name="user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "presentation_id", referencedColumnName = "id")})
    private List<Presentation> presentations;

    private User(){
    }

    public User(String email, String password) {
        this.name = email;
        this.password = password;
    }

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

    public List<Presentation> getPresentations() {
        return presentations;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + name +
                ", passwordHash='" + password.substring(0, 10) +
                '}';
    }
}
