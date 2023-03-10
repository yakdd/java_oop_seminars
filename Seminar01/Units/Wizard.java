package Units;

public class Wizard extends ClassMagician {

    public Wizard() {
        super(400, 250, 100, 50);
    }

    @Override
    public String toString() {
        return "Wizard: " + super.toString() + ".";
    }

    public void attack(ClassUnit target) {
        super.attack(target, this.damage);
    }
}
