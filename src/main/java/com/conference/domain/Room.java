package com.conference.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Room {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "roomId")
    private Set<Presentation> presentations = new HashSet<Presentation>(0);

    public Room() {
    }

    public Room(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Presentation> getPresentations() {
        return presentations;
    }

    public void setPresentations(Set<Presentation> presentations) {
        this.presentations = presentations;
    }

    @Override
    public String toString() {
        return String.format(
                "Room[id=%d, name='%s']",
                id, name);
    }
}
