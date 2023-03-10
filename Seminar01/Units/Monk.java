package Units;

public class Monk extends ClassMagician {

    public Monk() {
        super(300, 150, 300, 100);
    }

    @Override
    public String toString() {
        return "Monk: " + super.toString() + ".";
    }

    public void attack(ClassUnit target) {
        super.attack(target, this.damage);
    }
}
