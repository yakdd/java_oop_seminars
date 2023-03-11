package Units;

import java.util.Random;

public abstract class ClassUnit implements InterfaceUnit {

    protected Random rnd = new Random();

    protected String typeUnit;
    protected float hp;
    protected int speed;
    protected int damage;
    protected final String NAME;

    public ClassUnit(String typeUnit, float hp, int speed, int damage, String name) {
        this.hp = hp;
        this.speed = speed;
        this.damage = damage;
        this.typeUnit = typeUnit;
        NAME = name;
    }

    public void getNAME() {
        System.out.println(NAME);
    }

    @Override
    public void step() {
        System.out.println(">>>");
    }

    @Override
    public String getInfo() {
        return "заглушка";
    }

    @Override
    public String toString() {
        return "hp=" + hp + ", speed=" + speed + ", damage=" + damage;
    }

    // ==================================================================
    public void getDamage(int damage) {
        if (this.hp - damage > 0) {
            this.hp -= damage;
        } else
            this.hp = 0;
    }

    public void attack(ClassUnit target, int damage) {
        int causedDamage = rnd.nextInt(1, damage);
        System.out.printf("%s attack %s... ", this.typeUnit, target.typeUnit);
        System.out.printf("Power of knock = %d\n", causedDamage);
        target.getDamage(causedDamage);
    }
}
