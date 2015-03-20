package com.conference.domain;

import javax.persistence.*;

@Entity
public class Presentation {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Long roomId;



    public Presentation(String name, Long roomId) {
        this.name = name;
        this.roomId = roomId;
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

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }


    @Override
    public String toString() {
        return String.format(
                "Presentation[id=%d, name='%s', roomId='%d']",
                id, name, roomId);
    }
}
