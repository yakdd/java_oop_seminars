package Units;

import java.util.ArrayList;

public class Wizard extends ClassMagician {

    String personalName;

    public Wizard(String name, int x, int y) {
        super(17, 12, new int[] { -5, -5 }, 30, 9, 1, name, x, y);
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
        // System.out.println("Wizard_step");
    }

    @Override
    public String getInfo() {
        return "Wizard";
    }
}
