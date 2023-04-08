package com.mygdx.game.Units;

import java.util.ArrayList;

public abstract class ClassInfantery extends ClassUnit {

    // parameters order: attack, defence, damage[], hp, speed, name, x_pos, y_pos
    public ClassInfantery(int attack, int defence, int[] damage, float hp, int speed, String name, int x, int y) {
        super(attack, defence, damage, hp, speed, name, x, y);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public void step(ArrayList<ClassUnit> enemy, ArrayList<ClassUnit> friends) {

        if (this.hp > 0) {
            // поиск цели на минимальном расстоянии:
            Object target = position.getTarget(enemy);
            if (target instanceof ClassUnit) {
                // атака цели (если цель найдена):
                ClassUnit targetUnit = (ClassUnit) target;
                if (this.position.getDistance(targetUnit) > 1) {
                    this.position.getDirection(targetUnit.position, friends);
                } else if ((targetUnit).hp > 0) {
                    attackEnemy(targetUnit);
                }
            } else {
                System.out.println("Живых врагов нет!");
            }
        }
    }
}
