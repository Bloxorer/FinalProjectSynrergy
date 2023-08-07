package model;

import java.io.Serializable;

public class Bottles implements Serializable {
    private String name;
    private String number;
    private String id;

    public Bottles(String name, String number, String id) {
        this.name = name;
        this.number = number;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
