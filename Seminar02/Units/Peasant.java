package Units;

public class Peasant extends ClassPlebeius {

    public static String typeUnit = "Peasant";

    public Peasant(String name) {
        super(typeUnit, 90, 2, 3, name);
    }

    @Override
    public String toString() {
        if (this.hp <= 0)
            return typeUnit + " is die.";
        return typeUnit + ": " + super.toString() + ".";
    }

    @Override
    public void step() {
        System.out.println("Peasant_step");
    }

    @Override
    public String getInfo() {
        return "Peasant";
    }

    public void attack(ClassUnit target) {
        super.attack(target, this.damage);
    }
}
