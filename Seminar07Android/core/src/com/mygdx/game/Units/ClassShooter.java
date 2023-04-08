package com.mygdx.game.Units;

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
            Object target = position.getTarget(enemy);
            if (target instanceof ClassUnit) {
                // атака цели (если цель найдена):
                ClassUnit targetUnit = (ClassUnit) target;
                attackEnemy(targetUnit);
                // поиск крестьянина среди своих:
                for (ClassUnit unit : friends) {
                    if (unit.getInfo().equals("Peasant"))
                        return;
                    this.arrows--;
                }
            } else {
                System.out.println("Живых врагов нет!");
            }
        }
    }
}
