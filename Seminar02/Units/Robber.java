package Units;

public class Robber extends ClassInfantery {

    public static String typeUnit = "Robber";

    public Robber(String name) {
        super(typeUnit, 40, 80, 4, 4, name);
    }

    @Override
    public String toString() {
        if (this.hp <= 0)
            return typeUnit + " is die.";
        return typeUnit + ": " + super.toString() + ".";
    }

    @Override
    public void step() {
        System.out.println("Robber_step");
    }

    @Override
    public String getInfo() {
        return "Robber";
    }

    public void attack(ClassUnit target) {
        this.weapon -= 1;
        super.attack(target, this.damage);
    }

}
