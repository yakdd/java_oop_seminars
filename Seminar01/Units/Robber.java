package Units;

public class Robber extends ClassInfantery {

    public Robber() {
        super(40, 80, 4, 4);
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
