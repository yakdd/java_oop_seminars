package Units;

public class Monk extends ClassMagician {

    public static String typeUnit = "Monk";

    public Monk(String name) {
        super(typeUnit, 300, 150, 300, 100, name);
    }

    @Override
    public String toString() {
        if (this.hp <= 0)
            return typeUnit + " is die.";
        return typeUnit + ": " + super.toString() + ".";
    }

    @Override
    public void step() {
        System.out.println("Monk_step");
    }

    @Override
    public String getInfo() {
        return "Monk";
    }

    public void attack(ClassUnit target) {
        this.manna -= 10;
        super.attack(target, this.damage);
    }
}
