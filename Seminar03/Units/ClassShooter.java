package Units;

import java.util.ArrayList;

public abstract class ClassShooter extends ClassUnit {

    protected int arrows; // выстрелы

    // parameters order: type, attack, defence, damage, hp, speed, personals, name
    public ClassShooter(String typeUnit, int attack, int defence, int[] damage, float hp, int speed,
            int arrows, String name) {
        super(typeUnit, attack, defence, damage, hp, speed, name);
        this.arrows = arrows;
    }

    @Override
    public String toString() {
        return super.toString() + ", arrows=" + arrows;
    }

    @Override
    public void step(ArrayList<ClassUnit> enemy, ArrayList<ClassUnit> friends) {
        /** поиск противника для выстрела */
        if (this.hp <= 0 || this.arrows <= 0) {
            System.out.println("Выстрел невозможен.");
        } else {
            for (ClassUnit unit : enemy) {
                if (unit.hp > 0) {
                    this.arrows--;
                    unit.hp -= (this.damage[0] + this.damage[1]) / this.damage.length;
                    System.out.println("  " + this);
                    System.out.println("  " + unit);
                    break;
                }
            }
        }

        /** поиск крестьянина среди своих */
        // for (ClassUnit unit : friends) {
        // if (unit.getInfo().equals("Peasant")) {
        // return;
        // }
        // this.arrows--;
        // }
    }
}
