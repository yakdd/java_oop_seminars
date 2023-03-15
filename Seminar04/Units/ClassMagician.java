package Units;

public abstract class ClassMagician extends ClassUnit {

    protected int manna; // магия

    // parameters order: attack, defence, damage[], hp, speed, name, x_pos, y_pos
    public ClassMagician(int attack, int defence, int[] damage, float hp, int speed,
            int manna, String name, int x, int y) {
        super(attack, defence, damage, hp, speed, name, x, y);
        this.manna = manna;
    }

    @Override
    public String toString() {
        return super.toString() + ", manna=" + manna;
    }
}
