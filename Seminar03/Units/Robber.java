package Units;

import java.util.ArrayList;

public class Robber extends ClassInfantery {

    public static String typeUnit = "Robber";
    String personalName;

    public Robber(String name) {
        super(typeUnit, 8, 3, new int[] { 2, 4 }, 10, 6, name);
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
        System.out.println("Robber_step");
    }

    @Override
    public String getInfo() {
        return "Robber";
    }
}
