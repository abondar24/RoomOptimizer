package org.abondar.industrial.roomoptimizer.model;

import java.util.List;

public class Resource {

    private List<Integer> rooms;
    private int senior;
    private int junior;

    public Resource(){}

    public Resource(List<Integer> rooms, int senior, int junior) {
        this.rooms = rooms;
        this.senior = senior;
        this.junior = junior;
    }

    public List<Integer> getRooms() {
        return rooms;
    }

    public void setRooms(List<Integer> rooms) {
        this.rooms = rooms;
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
                "rooms=" + rooms +
                ", senior=" + senior +
                ", junior=" + junior +
                '}';
    }
}
