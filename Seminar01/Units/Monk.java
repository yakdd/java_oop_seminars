package Units;

public class Monk extends ClassMagician {

    public Monk() {
        super(300, 150, 300, 100);
    }

    @Override
    public String toString() {
        if (this.hp <= 0)
            return "Monk is die.";
        return "Monk: " + super.toString() + ".";
    }

    public void attack(ClassUnit target) {
        super.attack(target, this.damage);
    }
}
