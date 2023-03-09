package Units;

public class Peasant extends ClassPlebeius {

    public Peasant() {
        super(90, 2, 3);
    }

    @Override
    public String toString() {
        return "Peasant: " + super.toString() + ".";
    }

    public void attack(ClassUnit target) {
        super.attack(target, this.damage);
    }
}
