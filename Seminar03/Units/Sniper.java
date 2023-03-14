package Units;

import java.util.ArrayList;

public class Sniper extends ClassShooter {

    public static String typeUnit = "Sniper";
    String personalName;

    public Sniper(String name) {
        super(typeUnit, 12, 10, new int[] { 8, 10 }, 15, 9, 32, name);
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
    }

    @Override
    public String getInfo() {
        return "Sniper";
    }
}
