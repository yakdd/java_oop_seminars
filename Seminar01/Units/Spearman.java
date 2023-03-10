package Units;

public class Spearman extends ClassInfantery {

    public Spearman() {
        super(52, 5, 10, 44);
    }

    @Override
    public String toString() {
        String unit = this.getClass().getSimpleName();
        if (this.hp <= 0)
            return unit + " is die.";
        return unit + ": " + super.toString() + ".";
    }

    public void attack(ClassUnit target) {
        super.attack(target, this.damage);
    }
}
