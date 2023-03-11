package Units;

public abstract class ClassShooter extends ClassUnit {

    protected int arrows;

    public ClassShooter(String typeUnit, float hp, int speed, int damage, int arrows, String name) {
        super(typeUnit, hp, speed, damage, name);
        this.arrows = arrows;
    }

    @Override
    public String toString() {
        return super.toString() + ", arrows=" + arrows;
    }
}
