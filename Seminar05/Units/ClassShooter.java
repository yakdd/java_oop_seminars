package Units;

import java.util.ArrayList;

public abstract class ClassShooter extends ClassUnit {

    protected int arrows; // выстрелы

    // parameters order: attack, defence, damage[], hp, speed, name, x_pos, y_pos
    public ClassShooter(int attack, int defence, int[] damage, float hp, int speed,
            int arrows, String name, int x, int y) {
        super(attack, defence, damage, hp, speed, name, x, y);
        this.arrows = arrows;
    }

    @Override
    public String toString() {
        return super.toString() + ", arrows=" + arrows;
    }

    @Override
    public void step(ArrayList<ClassUnit> enemy, ArrayList<ClassUnit> friends) {
        if (this.hp > 0 && this.arrows > 0) {
            // поиск цели на минимальном расстоянии:
            ClassUnit target = null;
            double minDistance = 14.2; // ~ (10^2 + 10^2) ^ 0.5
            for (ClassUnit unit : enemy) {
                double unitDistance = position.getDistance(unit);
                if (unitDistance < minDistance) {
                    minDistance = unitDistance;
                    target = unit;
                }
            }
            // выстрел по цели (если цель найдена):
            if (target != null) {
                target.hp -= (this.damage[0] + this.damage[1]) / this.damage.length;
                if (target.hp < 0)
                    target.hp = 0;

                // поиск крестьянина среди своих:
                for (ClassUnit unit : friends) {
                    if (unit.getInfo().equals("Peasant"))
                        return;
                    this.arrows--;
                }
            }
        } else {
            System.out.println("Выстрел невозможен.");
        }

    }
}
