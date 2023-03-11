package Units;

public class Sniper extends ClassShooter {

    public static String typeUnit = "Sniper";

    public Sniper(String name) {
        super(typeUnit, 79, 5, 6, 10, name);
    }

    @Override
    public String toString() {
        if (this.hp <= 0)
            return typeUnit + " is die.";
        return typeUnit + ": " + super.toString() + ".";
    }

    @Override
    public void step() {
        System.out.println("Sniper_step");
    }

    @Override
    public String getInfo() {
        return "Sniper";
    }

    public void attack(ClassUnit target) {
        this.arrows -= 1;
        super.attack(target, this.damage);
    }
}
