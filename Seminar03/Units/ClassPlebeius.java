package Units;

public abstract class ClassPlebeius extends ClassUnit {

    protected int delivery; // доставка

    // parameters order: type, attack, defence, damage, hp, speed, personals, name
    public ClassPlebeius(String typeUnit, int attack, int defence, int[] damage, float hp, int speed,
            int delivery, String name) {
        super(typeUnit, attack, defence, damage, hp, speed, name);
        this.delivery = delivery;
    }

    @Override
    public String toString() {
        return super.toString() + ", delivery=" + delivery;
    }
}
