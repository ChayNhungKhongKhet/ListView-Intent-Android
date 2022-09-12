package com.phamtantb24.listviewevent;

import java.io.Serializable;
import java.time.LocalDate;

public class Combatant implements Serializable {
    private String name;
    private int power;
    private int image;

    public Combatant(String name, int power, int image) {
        this.name = name;
        this.power = power;
        this.image = image;
    }

    public Combatant() {
    }

    public Combatant(String name, int power) {
        this.name = name;
        this.power = power;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
