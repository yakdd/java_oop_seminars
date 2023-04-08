package com.mygdx.game.Units;

import java.util.ArrayList;

public abstract class ClassMagician extends ClassUnit {

    protected float manna; // магия
    protected float maxManna = manna;

    // parameters order: attack, defence, damage[], hp, speed, name, x_pos, y_pos
    public ClassMagician(int attack, int defence, int[] damage, float hp, int speed,
            float manna, String name, int x, int y) {
        super(attack, defence, damage, hp, speed, name, x, y);
        this.manna = manna;
    }

    @Override
    public String toString() {
        return super.toString() + ", manna=" + manna;
    }

    @Override
    public void step(ArrayList<ClassUnit> enemy, ArrayList<ClassUnit> friends) {
        if (this.manna > 0) {

            for (ClassUnit target : friends) {
                if (this.manna > 0) {

                    if (target.hp > 0 && target.hp < target.maxHp) {
                        float beforeHp = target.hp;
                        attackEnemy(target); // наносим цели отрицательный урон
                        if (target.hp > target.maxHp)
                            target.hp = target.maxHp;
                        this.manna -= (target.hp - beforeHp);
                    }
                } else
                    break;
            }
        } else {
            if (this.hp > 0) { // если еще есть здоровье,
                if (this.manna < this.maxManna) { // и магия еще не превысила максимума, то
                    this.manna += this.maxManna * 10 / 100; // увеличиваем магию на 10 процентов,
                    if (this.manna > this.maxManna)
                        this.manna = this.maxManna;
                    this.hp -= this.maxHp * 10 / 100; // одновременно пропорционально уменьшая здоровье.
                }
            }
        }
    }
}
