package com.conference.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Presentation {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne(optional = false)
    private Room room;

    @ManyToMany(mappedBy = "presentations")
    private List<User> users;

    protected Presentation() {
    }

    public Presentation(String name, Room room) {
        this.name = name;
        this.room = room;
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

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public List<User> getUsers() {
        return users;
    }

    @Override
    public String toString() {
        return String.format(
                "Presentation[id=%d, name='%s']",
                id, name);
    }
}
