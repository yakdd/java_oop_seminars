package Units;

public class Peasant extends ClassPlebeius {

    public Peasant() {
        super(90, 2, 3);
    }

    @Override
    public String toString() {
        String unit = this.getClass().getSimpleName();
        if (this.hp <= 0)
            return unit + " is die.";
        return unit + ": " + super.toString() + ".";
    }

    public void attack(ClassUnit target) {
        super.attack(target, this.damage);
    }
}
