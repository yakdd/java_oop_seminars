package Units;

public class Wizard extends ClassMagician {

    public Wizard() {
        super(400, 250, 100, 50);
    }

    @Override
    public String toString() {
        if (this.hp <= 0)
            return "Wizard is die.";
        return "Wizard: " + super.toString() + ".";
    }

    public void attack(ClassUnit target) {
        super.attack(target, this.damage);
    }
}
