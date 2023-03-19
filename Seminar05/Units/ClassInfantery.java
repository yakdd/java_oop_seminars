package Units;

public abstract class ClassInfantery extends ClassUnit {

    // parameters order: attack, defence, damage[], hp, speed, name, x_pos, y_pos
    public ClassInfantery(int attack, int defence, int[] damage, float hp, int speed, String name, int x, int y) {
        super(attack, defence, damage, hp, speed, name, x, y);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
