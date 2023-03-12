package Units;

import java.util.ArrayList;

public class Spearman extends ClassInfantery {

    public static String typeUnit = "Spearman";
    String personalName;

    public Spearman(String name) {
        super(typeUnit, 4, 5, new int[] { 1, 3 }, 10, 4, name);
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
        System.out.println("Spearman_step");
    }

    @Override
    public String getInfo() {
        return "Spearman";
    }
}
