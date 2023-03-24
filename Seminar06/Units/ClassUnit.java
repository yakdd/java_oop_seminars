package Units;

import java.util.ArrayList;
import java.util.Random;

public abstract class ClassUnit implements InterfaceUnit {

    protected Random rnd = new Random();

    protected int attack; // атака
    protected int defence; // защита
    protected int[] damage; // урон
    protected float hp; // здоровье
    protected float maxHp; // здоровье
    protected int speed; // скорость
    protected final String NAME;// имя
    protected ClassPosition position; // координаты

    // parameters order: attack, defence, damage[], hp, speed, name, x_pos, y_pos
    public ClassUnit(int attack, int defence, int[] damage, float hp, int speed, String name, int x, int y) {
        this.attack = attack;
        this.defence = defence;
        this.hp = hp;
        this.maxHp = hp;
        this.speed = speed;
        this.damage = damage;
        NAME = name;
        position = new ClassPosition(x, y);
    }

    @Override
    public void step(ArrayList<ClassUnit> enemy, ArrayList<ClassUnit> friends) {
        System.out.println(">>>");
    }

    public void attackEnemy(ClassUnit targetUnit) {
        (targetUnit).hp -= (this.damage[0] + this.damage[1]) / this.damage.length;
        if (targetUnit.hp < 0)
            targetUnit.hp = 0;
    }

    @Override
    public String getInfo() {
        return "";
    }

    @Override
    public String toString() {
        if (damage[0] != damage[1])
            return "attack=" + attack + ", defence=" + defence + ", hp=" + hp + ", speed=" + speed + ", damage: min="
                    + damage[0] + " max=" + damage[1];
        return "hp=" + hp + ", speed=" + speed + ", damage=" + damage[0];
    }

    public String smileStr() {
        String outStr = String.format("%-25s   \u2694 :%d   \uD83D\uDEE1 :%d   \u2764 :%.0f%%   \u2620 :%-3d\t",
                getInfo() + " " + getNAME(),
                this.attack,
                this.defence,
                hp * 100 / maxHp,
                (damage[0] + damage[1]) / 2);
        return outStr;
    }

    public String getNAME() {
        return NAME;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefence() {
        return defence;
    }

    public int[] getDamage() {
        return damage;
    }

    public float getHp() {
        return hp;
    }

    public int getSpeed() {
        return speed;
    }

    public ClassPosition getPosition() {
        return position;
    }
}
