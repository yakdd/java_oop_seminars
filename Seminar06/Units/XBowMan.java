package Units;

import java.util.ArrayList;

public class XBowMan extends ClassShooter {

    String personalName;

    public XBowMan(String name, int x, int y) {
        super(6, 3, new int[] { 7, 9 }, 20, 4, 16, name, x, y);
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
        return "XBowMan";
    }
}
