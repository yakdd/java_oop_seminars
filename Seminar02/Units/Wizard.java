package Units;

public class Wizard extends ClassMagician {

    public static String typeUnit = "Wizard";

    public Wizard(String name) {
        super(typeUnit, 400, 250, 100, 50, name);
    }

    @Override
    public String toString() {
        if (this.hp <= 0)
            return typeUnit + " is die.";
        return typeUnit + ": " + super.toString() + ".";
    }

    @Override
    public void step() {
        System.out.println("Wizard_step");
    }

    @Override
    public String getInfo() {
        return "Wizard";
    }

    public void attack(ClassUnit target) {
        this.manna -= 10;
        super.attack(target, this.damage);
    }
}
