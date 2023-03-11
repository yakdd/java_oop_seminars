import java.util.ArrayList;
import java.util.Random;
import Units.*;

public class Main {
    public static void main(String[] args) {

        ArrayList<ClassUnit> unitsList1 = new ArrayList<>();
        ArrayList<ClassUnit> unitsList2 = new ArrayList<>();

        for (int index = 0; index < 10; index++) {
            switch (new Random().nextInt(4)) {
                case 0:
                    unitsList1.add(new Peasant(getName()));
                    unitsList2.add(new Peasant(getName()));
                    break;
                case 1:
                    unitsList1.add(new Robber(getName()));
                    unitsList2.add(new Spearman(getName()));
                    break;
                case 2:
                    unitsList1.add(new Sniper(getName()));
                    unitsList2.add(new XBowMan(getName()));
                    break;
                case 3:
                    unitsList1.add(new Wizard(getName()));
                    unitsList2.add(new Monk(getName()));
                    break;
            }
        }

        System.out.println("\nUnits List 1:");
        for (int i = 0; i < unitsList1.size(); i++) {
            ClassUnit unit = unitsList1.get(i);
            System.out.printf("%d. %s - ", i + 1, unit.getInfo());
            unit.getNAME();
        }

        System.out.println("\nUnits List 2:");
        for (int i = 0; i < unitsList2.size(); i++) {
            ClassUnit unit = unitsList2.get(i);
            System.out.printf("%d. %s - ", i + 1, unit.getInfo());
            unit.getNAME();
        }
    }

    private static String getName() {
        return EnumNames.values()[new Random().nextInt(EnumNames.values().length)].toString();
    }
}
