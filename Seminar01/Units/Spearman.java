package Units;

public class Spearman extends ClassInfantery {

    public Spearman() {
        super(52, 5, 10, 44);
    }

    @Override
    public String toString() {
        if (this.hp <= 0)
            return "Spearman is die.";
        return "Spearman: " + super.toString() + ".";
    }

    public void attack(ClassUnit target) {
        super.attack(target, this.damage);
    }
}
