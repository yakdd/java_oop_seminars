package Units;

import java.util.Random;

public class ClassUnit {

    protected Random rnd = new Random();

    protected float hp;
    protected int speed;
    protected int damage;

    public ClassUnit(float hp, int speed, int damage) {
        this.hp = hp;
        this.speed = speed;
        this.damage = damage;
    }

    @Override
    public String toString() {
        return "hp=" + hp + ", speed=" + speed + ", damage=" + damage;
    }

    public void getDamage(int damage) {
        if (this.hp - damage > 0) {
            this.hp -= damage;
        } else
            this.hp = 0;
    }

    public void attack(ClassUnit target, int damage) {
        int causedDamage = rnd.nextInt(1, damage);
        System.out.printf("%s attack %s\t", this.getClass().getSimpleName(), target.getClass().getSimpleName());
        System.out.printf("Power of knock = %d\n", causedDamage);
        target.getDamage(causedDamage);
    }

}
