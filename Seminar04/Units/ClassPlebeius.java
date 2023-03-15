package Units;

public abstract class ClassPlebeius extends ClassUnit {

    protected int delivery; // доставка

    // parameters order: attack, defence, damage[], hp, speed, name, x_pos, y_pos
    public ClassPlebeius(int attack, int defence, int[] damage, float hp, int speed,
            int delivery, String name, int x, int y) {
        super(attack, defence, damage, hp, speed, name, x, y);
        this.delivery = delivery;
    }

    @Override
    public String toString() {
        return super.toString() + ", delivery=" + delivery;
    }
}
