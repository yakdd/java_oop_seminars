package Units;

import java.util.ArrayList;

public class LanceBearer extends ClassInfantery {

    String personalName;

    public LanceBearer(String name, int x, int y) {
        super(4, 5, new int[] { 4, 6 }, 9, 7, name, x, y);
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
        return "LanceBearer";
    }
}
