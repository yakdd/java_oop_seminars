package Units;

public class XBowMan extends ClassShooter {

    public XBowMan() {
        super(50, 6, 12, 56);
    }

    @Override
    public String toString() {
        if (this.hp <= 0)
            return "XBowMan is die.";
        return "XBowMan: " + super.toString() + ".";
    }

    public void attack(ClassUnit target) {
        super.attack(target, this.damage);
    }
}
