package Units;

public class ClassInfantery extends ClassUnit {

    protected int weapon;

    public ClassInfantery(float hp, int speed, int damage, int weapon) {
        super(hp, speed, damage);
        this.weapon = weapon;
    }

    @Override
    public String toString() {
        return super.toString() + ", weapon=" + weapon;
    }

    public void attack(ClassUnit target, int damage) {
        this.weapon -= 1;
        super.attack(target, damage);
    }

}
