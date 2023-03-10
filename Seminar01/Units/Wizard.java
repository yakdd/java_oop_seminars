package Units;

public class Wizard extends ClassMagician {

    public Wizard() {
        super(400, 250, 100, 50);
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
