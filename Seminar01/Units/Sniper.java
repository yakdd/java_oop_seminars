package Units;

public class Sniper extends ClassShooter {

    public Sniper() {
        super(79, 5, 6, 10);
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
