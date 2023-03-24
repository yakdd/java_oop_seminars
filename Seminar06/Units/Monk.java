package Units;

import java.util.ArrayList;

public class Monk extends ClassMagician {

    String personalName;

    public Monk(String name, int x, int y) {
        super(12, 7, new int[] { -4, -4 }, 30, 5, 1, name, x, y);
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
        // System.out.println("Monk_step");
    }

    @Override
    public String getInfo() {
        return "Monk";
    }
}
