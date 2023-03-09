package Units;

public class ClassSooter extends ClassUnit {

    protected int arrows;

    public ClassSooter(float hp, int speed, int damage, int arrows) {
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
