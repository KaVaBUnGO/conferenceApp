package com.conference.domain;

import java.util.ArrayList;

public class ScheduleRow {

    private String presentationName;
    private String roomName;
    private ArrayList<String> authors;

    public ScheduleRow(String presentationName, String roomName, ArrayList<String> authors) {
        this.presentationName = presentationName;
        this.roomName = roomName;
        this.authors = authors;
    }

    public String getPresentationName() {
        return presentationName;
    }

    public void setPresentationName(String presentationName) {
        this.presentationName = presentationName;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public ArrayList<String> getAuthors() {
        return authors;
    }

    public void setAuthors(ArrayList<String> authors) {
        this.authors = authors;
    }
}
