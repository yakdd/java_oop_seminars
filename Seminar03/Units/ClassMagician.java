package Units;

public abstract class ClassMagician extends ClassUnit {

    protected int manna; // магия

    // parameters order: type, attack, defence, damage, hp, speed, personals, name
    public ClassMagician(String typeUnit, int attack, int defence, int[] damage, float hp, int speed,
            int manna, String name) {
        super(typeUnit, attack, defence, damage, hp, speed, name);
        this.manna = manna;
    }

    @Override
    public String toString() {
        return super.toString() + ", manna=" + manna;
    }
}
