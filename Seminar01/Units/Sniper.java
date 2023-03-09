package Units;

public class Sniper extends ClassSooter {

    public Sniper() {
        super(79, 5, 6, 10);
    }

    @Override
    public String toString() {
        return "Sniper: " + super.toString() + ".";
    }

    public void attack(ClassUnit target) {
        super.attack(target, this.damage);
    }
}
