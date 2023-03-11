package Units;

public class Spearman extends ClassInfantery {

    public static String typeUnit = "Spearman";

    public Spearman(String name) {
        super(typeUnit, 52, 5, 10, 44, name);
    }

    @Override
    public String toString() {
        if (this.hp <= 0)
            return typeUnit + " is die.";
        return typeUnit + ": " + super.toString() + ".";
    }

    @Override
    public void step() {
        System.out.println("Spearman_step");
    }

    @Override
    public String getInfo() {
        return "Spearman";
    }

    public void attack(ClassUnit target) {
        this.weapon -= 1;
        super.attack(target, this.damage);
    }
}
