package Units;

import java.util.ArrayList;

public class Monk extends ClassMagician {

    public static String typeUnit = "Monk";
    String personalName;

    public Monk(String name) {
        super(typeUnit, 12, 7, new int[] { -4, -4 }, 30, 5, 1, name);
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
        System.out.println("Monk_step");
    }

    @Override
    public String getInfo() {
        return "Monk";
    }
}
