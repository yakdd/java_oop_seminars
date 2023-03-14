import java.util.ArrayList;
import java.util.Comparator;
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
        for (ClassUnit unit : unitsList1) {
            System.out.println(unit);
        }
        System.out.println("\nUnits List 2:");
        for (ClassUnit unit : unitsList2) {
            System.out.println(unit);
        }

        /** сортировка: ======================================================== */
        ArrayList<ClassUnit> allUnits = new ArrayList<>();
        allUnits.addAll(unitsList1);
        allUnits.addAll(unitsList2);
        allUnits.sort(new Comparator<ClassUnit>() {
            @Override
            public int compare(ClassUnit u1, ClassUnit u2) {
                if (u2.getSpeed() == u1.getSpeed()) { // если speed равны,
                    return (int) u2.getHp() - (int) u1.getHp(); // сортируем по убыванию hp
                }
                return u2.getSpeed() - u1.getSpeed();
            }
        });

        System.out.println("\n Отсортирванный список юнитов:");
        for (int i = 0; i < allUnits.size(); i++) {
            System.out.printf("%d. %s\n", i + 1, allUnits.get(i));
        }
        System.out.println();

        /** обмен выстрелами: ================================================== */
        for (ClassUnit unit : unitsList1) {
            if (unit.getTypeUnit().equals("Sniper")) {
                System.out.printf("Sniper %s делает выстрел:\n", unit.getNAME());
                unit.step(unitsList2, unitsList1);
                break;
            }
        }

        for (ClassUnit unit : unitsList2) {
            if (unit.getTypeUnit().equals("XBowMan")) {
                System.out.printf("XBowMan %s делает выстрел:\n", unit.getNAME());
                unit.step(unitsList1, unitsList2);
                break;
            }
        }
    }

    private static String getName() {
        return EnumNames.values()[new Random().nextInt(EnumNames.values().length)].toString();
    }
}
