package Units;

import java.util.ArrayList;

public class XBowMan extends ClassShooter {

    public static String typeUnit = "XBowMan";
    String personalName;

    public XBowMan(String name) {
        super(typeUnit, 6, 3, new int[] { 2, 3 }, 10, 4, 16, name);
        this.personalName = name;
    }

    @Override
    public String toString() {
        if (this.hp <= 0)
            return typeUnit + " is die.";
        return typeUnit + " (" + this.personalName + "): " + super.toString() + ".";
    }

    @Override
    public void step(ArrayList<ClassUnit> enemy, ArrayList<ClassUnit> friends) {
        super.step(enemy, friends);
        ;
    }

    @Override
    public String getInfo() {
        return "XBowMan";
    }
}
