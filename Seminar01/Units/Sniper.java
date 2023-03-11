package Units;

public class Sniper extends ClassShooter {

    public Sniper() {
        super(79, 5, 6, 10);
    }

    @Override
    public String toString() {
        if (this.hp <= 0)
            return "Sniper is die.";
        return "Sniper: " + super.toString() + ".";
    }

    public void attack(ClassUnit target) {
        super.attack(target, this.damage);
    }
}
