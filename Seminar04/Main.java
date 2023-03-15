import java.util.ArrayList;
// import java.util.Comparator;
import java.util.Random;
import Units.*;

public class Main {
    public static void main(String[] args) {

        ClassPosition.fillGameBoard();

        ArrayList<ClassUnit> unitsList1 = new ArrayList<>();
        ArrayList<ClassUnit> unitsList2 = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            int num = new Random().nextInt(4);
            switch (num) {
                case 0:
                    unitsList1.add(new Peasant(getName(), num, i));
                    unitsList2.add(new Peasant(getName(), 9 - num, i));
                    break;
                case 1:
                    unitsList1.add(new Wizard(getName(), num, i));
                    unitsList2.add(new Monk(getName(), 9 - num, i));
                    break;
                case 2:
                    unitsList1.add(new Sniper(getName(), num, i));
                    unitsList2.add(new XBowMan(getName(), 9 - num, i));
                    break;
                case 3:
                    unitsList1.add(new Robber(getName(), num, i));
                    unitsList2.add(new LanceBearer(getName(), 9 - num, i));
                    break;
            }
        }

        printTeams(unitsList1, unitsList2);
        ClassPosition.printGameBoard();
        System.out.println("------------------------------------------------------------");

        /** сортировка: ======================================================== */
        // ArrayList<ClassUnit> allUnits = new ArrayList<>();
        // allUnits.addAll(unitsList1);
        // allUnits.addAll(unitsList2);
        // allUnits.sort(new Comparator<ClassUnit>() {
        // @Override
        // public int compare(ClassUnit u1, ClassUnit u2) {
        // if (u2.getSpeed() == u1.getSpeed()) { // если speed равны,
        // return (int) u2.getHp() - (int) u1.getHp(); // сортируем по убыванию hp
        // }
        // return u2.getSpeed() - u1.getSpeed();
        // }
        // });
        //
        // System.out.println("\n Отсортирванный список юнитов:");
        // for (int i = 0; i < allUnits.size(); i++) {
        // System.out.printf("%d. %s\n", i + 1, allUnits.get(i));
        // }
        System.out.println();

        /** обмен выстрелами: ================================================== */
        for (ClassUnit unit : unitsList1) {
            if (unit.getInfo().equals("Sniper")) {
                System.out.printf("Sniper %s делает выстрел:\n", unit.getNAME());
                unit.step(unitsList2, unitsList1);
            }
        }

        for (ClassUnit unit : unitsList2) {
            if (unit.getInfo().equals("XBowMan")) {
                System.out.printf("XBowMan %s делает выстрел:\n", unit.getNAME());
                unit.step(unitsList1, unitsList2);
            }
        }

        System.out.println("------------------------------------------------------------");
        printTeams(unitsList1, unitsList2);
        ClassPosition.printGameBoard();
    }

    private static String getName() {
        return EnumNames.values()[new Random().nextInt(EnumNames.values().length)].toString();
    }

    private static void printTeams(ArrayList<ClassUnit> team1, ArrayList<ClassUnit> team2) {
        System.out.println("\nUnits List 1:");
        for (ClassUnit unit : team1)
            System.out.println(unit);

        System.out.println("\nUnits List 2:");
        for (ClassUnit unit : team2)
            System.out.println(unit);
    }
}
