package Units;

public class Peasant extends ClassPlebeius {

    public Peasant() {
        super(90, 2, 3);
    }

    @Override
    public String toString() {
        if (this.hp <= 0)
            return "Peasant is die.";
        return "Peasant: " + super.toString() + ".";
    }

    public void attack(ClassUnit target) {
        super.attack(target, this.damage);
    }
}
