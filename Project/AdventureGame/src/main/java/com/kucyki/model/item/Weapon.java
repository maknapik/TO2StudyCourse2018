package com.kucyki.model.item;

public class Weapon implements IItem {

    private String name;
    private int power;

    public Weapon(String name, int power) {
        this.name = name;
        this.power = power;
    }

}
