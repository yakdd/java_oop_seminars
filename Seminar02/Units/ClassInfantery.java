package Units;

public abstract class ClassInfantery extends ClassUnit {

    protected int weapon;

    public ClassInfantery(String typeUnit, float hp, int speed, int damage, int weapon, String name) {
        super(typeUnit, hp, speed, damage, name);
        this.weapon = weapon;
    }

    @Override
    public String toString() {
        return super.toString() + ", weapon=" + weapon;
    }
}
