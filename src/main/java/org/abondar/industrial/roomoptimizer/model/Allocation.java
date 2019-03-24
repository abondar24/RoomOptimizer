package org.abondar.industrial.roomoptimizer.model;

public class Allocation {

    private int senior;
    private int junior;

    public Allocation(){}

    public Allocation(int senior, int junior) {
        this.senior = senior;
        this.junior = junior;
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
        return "Allocation{" +
                "senior=" + senior +
                ", junior=" + junior +
                '}';
    }
}
