package Units;

import java.util.ArrayList;

public class Wizard extends ClassMagician {

    public static String typeUnit = "Wizard";
    String personalName;

    public Wizard(String name) {
        super(typeUnit, 17, 12, new int[] { -5, -5 }, 30, 9, 1, name);
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
        System.out.println("Wizard_step");
    }

    @Override
    public String getInfo() {
        return "Wizard";
    }
}
