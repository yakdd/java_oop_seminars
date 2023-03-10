package Units;

public class ClassMagician extends ClassUnit {

    protected int manna;

    public ClassMagician(float hp, int speed, int damage, int manna) {
        super(hp, speed, damage);
        this.manna = manna;
    }

    @Override
    public String toString() {
        return super.toString() + ", manna=" + manna;
    }

    public void attack(ClassUnit target, int damage) {
        this.manna -= 10;
        super.attack(target, damage);

    }

}
