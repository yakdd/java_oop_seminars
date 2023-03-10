package Units;

public class Robber extends ClassInfantery {

    public Robber() {
        super(40, 80, 4, 4);
    }

    @Override
    public String toString() {
        return "Robber: " + super.toString() + ".";
    }

    public void attack(ClassUnit target) {
        super.attack(target, this.damage);
    }

}
