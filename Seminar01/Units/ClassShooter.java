package Units;

public class ClassShooter extends ClassUnit {

    protected int arrows;

    public ClassShooter(float hp, int speed, int damage, int arrows) {
        super(hp, speed, damage);
        this.arrows = arrows;
    }

    @Override
    public String toString() {
        return super.toString() + ", arrows=" + arrows;
    }

    public void attack(ClassUnit target, int damage) {
        this.arrows -= 1;
        super.attack(target, damage);
    }

}
