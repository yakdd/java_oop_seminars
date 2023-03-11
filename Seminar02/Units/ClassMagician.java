package Units;

public abstract class ClassMagician extends ClassUnit {

    protected int manna;

    public ClassMagician(String typeUnit, float hp, int speed, int damage, int manna, String name) {
        super(typeUnit, hp, speed, damage, name);
        this.manna = manna;
    }

    @Override
    public String toString() {
        return super.toString() + ", manna=" + manna;
    }
}
