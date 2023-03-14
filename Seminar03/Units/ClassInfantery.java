package Units;

public abstract class ClassInfantery extends ClassUnit {

    // parameters order: type, attack, defence, damage, hp, speed, personals, name
    public ClassInfantery(String typeUnit, int attack, int defence, int[] damage, float hp, int speed, String name) {
        super(typeUnit, attack, defence, damage, hp, speed, name);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
