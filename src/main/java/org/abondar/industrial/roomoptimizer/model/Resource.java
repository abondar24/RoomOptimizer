package org.abondar.industrial.roomoptimizer.model;

import java.util.List;

public class Resource {

    private List<Integer> room;
    private int senior;
    private int junior;

    public Resource(){}

    public Resource(List<Integer> room, int senior, int junior) {
        this.room = room;
        this.senior = senior;
        this.junior = junior;
    }

    public List<Integer> getRoom() {
        return room;
    }

    public void setRoom(List<Integer> room) {
        this.room = room;
    }

    public int getSenior() {
        return senior;
    }

    public void setSenior(int senior) {
        this.senior = senior;
    }

    public int getJunior() {
        return junior;
    }

    public void setJunior(int junior) {
        this.junior = junior;
    }

    @Override
    public String toString() {
        return "Resource{" +
                "room=" + room +
                ", senior=" + senior +
                ", junior=" + junior +
                '}';
    }
}
