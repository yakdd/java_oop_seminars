package com.mygdx.game.Units;

import java.util.ArrayList;

public class Robber extends ClassInfantery {

    String personalName;

    public Robber(String name, int x, int y) {
        super(8, 3, new int[] { 2, 4 }, 11, 6, name, x, y);
        this.personalName = name;
    }

    @Override
    public String toString() {
        String typeUnit = getInfo();
        String coords = String.format("x:%d y:%d", this.position.x, this.position.y);
        if (this.hp <= 0)
            return typeUnit + " " + this.getNAME() + " is die.";
        return typeUnit + " (" + this.personalName + "): " + super.toString() + ", coords: " + coords + ".";
    }

    @Override
    public void step(ArrayList<ClassUnit> enemy, ArrayList<ClassUnit> friends) {
        super.step(enemy, friends);
    }

    @Override
    public String getInfo() {
        return "Robber";
    }
}
