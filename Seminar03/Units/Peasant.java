package Units;

import java.util.ArrayList;

public class Peasant extends ClassPlebeius {

    public static String typeUnit = "Peasant";
    String personalName;

    public Peasant(String name) {
        super(typeUnit, 1, 1, new int[] { 1, 1 }, 1, 3, 1, name);
        this.personalName = name;
    }

    @Override
    public String toString() {
        if (this.hp <= 0)
            return typeUnit + " " + this.getNAME() + " is die.";
        return typeUnit + " (" + this.personalName + "): " + super.toString() + ".";
    }

    @Override
    public void step(ArrayList<ClassUnit> enemy, ArrayList<ClassUnit> friends) {
        System.out.println("Peasant_step");
    }

    @Override
    public String getInfo() {
        return "Peasant";
    }
}
