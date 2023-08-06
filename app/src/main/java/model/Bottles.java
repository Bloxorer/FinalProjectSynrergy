package model;

public class Bottles {
    private String name;
    private int number;
    private int bottleResourse;

    public int getBottleResourse() {
        return bottleResourse;
    }

    public void setBottleResourse(int bottleResourse) {
        this.bottleResourse = bottleResourse;
    }

    public Bottles(String name, int number, int bottleResourse) {
        this.name = name;
        this.number = number;
        this.bottleResourse = bottleResourse;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
