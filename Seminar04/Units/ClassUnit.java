package Units;

import java.util.ArrayList;
import java.util.Random;

public abstract class ClassUnit implements InterfaceUnit {

    protected Random rnd = new Random();

    protected int attack; // атака
    protected int defence; // защита
    protected int[] damage; // урон
    protected float hp; // здоровье
    protected int speed; // скорость
    protected final String NAME;// имя
    protected ClassPosition position; // координаты

    // parameters order: attack, defence, damage[], hp, speed, name, x_pos, y_pos
    public ClassUnit(int attack, int defence, int[] damage, float hp, int speed, String name, int x, int y) {
        this.hp = hp;
        this.speed = speed;
        this.damage = damage;
        NAME = name;
        position = new ClassPosition(x, y, this.getInfo());
    }

    @Override
    public void step(ArrayList<ClassUnit> enemy, ArrayList<ClassUnit> friends) {
        System.out.println(">>>");
    }

    @Override
    public String getInfo() {
        return "";
    }

    @Override
    public String toString() {
        if (damage[0] != damage[1])
            return "hp=" + hp + ", speed=" + speed + ", damage: min=" + damage[0] + " max=" + damage[1];
        return "hp=" + hp + ", speed=" + speed + ", damage=" + damage[0];
    }

    public String getNAME() {
        return NAME;
    }

    // public String getTypeUnit() {
    // return typeUnit;
    // }

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

    // ==================================================================
    // public void getDamage(int damage) {
    // if (this.hp - damage > 0) {
    // this.hp -= damage;
    // } else
    // this.hp = 0;
    // }

    // public void attack(ClassUnit target, int damage) {
    // int causedDamage = rnd.nextInt(1, damage);
    // System.out.printf("%s attack %s... ", this.typeUnit, target.typeUnit);
    // System.out.printf("Power of knock = %d\n", causedDamage);
    // target.getDamage(causedDamage);
    // }

}
