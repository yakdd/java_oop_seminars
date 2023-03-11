package Units;

public class XBowMan extends ClassShooter {

    public static String typeUnit = "XBowMan";

    public XBowMan(String name) {
        super(typeUnit, 50, 6, 12, 56, name);
    }

    @Override
    public String toString() {
        if (this.hp <= 0)
            return typeUnit + " is die.";
        return typeUnit + ": " + super.toString() + ".";
    }

    @Override
    public void step() {
        System.out.println("XBowMan_step");
    }

    @Override
    public String getInfo() {
        return "XBowMan";
    }

    public void attack(ClassUnit target) {
        this.arrows -= 1;
        super.attack(target, this.damage);
    }
}
