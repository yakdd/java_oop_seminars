import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;

import Units.*;

public class Main {

    public static final int GANG_SIZE = 10;
    public static ArrayList<ClassUnit> darkSide;
    public static ArrayList<ClassUnit> whiteSide;
    public static ArrayList<ClassUnit> allUnits;

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        init();
        while (true) {
            System.out.println("For exit press 0");
            ConsoleView.view();
            System.out.println("---------------------------");
            String next = scan.nextLine();
            if (next.equals("0")) {
                scan.close();
                break;
            } else {
                step();
            }
        }
    }

    private static void init() {
        darkSide = new ArrayList<>();
        whiteSide = new ArrayList<>();
        allUnits = new ArrayList<>();

        for (int i = 0; i < GANG_SIZE; i++) {
            int num = new Random().nextInt(4);
            switch (num) {
                case 0:
                    whiteSide.add(new Peasant(getName(), num, i));
                    darkSide.add(new Peasant(getName(), GANG_SIZE - 1 - num, i));
                    break;
                case 1:
                    whiteSide.add(new Monk(getName(), num, i));
                    darkSide.add(new Wizard(getName(), GANG_SIZE - 1 - num, i));
                    break;
                case 2:
                    whiteSide.add(new XBowMan(getName(), num, i));
                    darkSide.add(new Sniper(getName(), GANG_SIZE - 1 - num, i));
                    break;
                case 3:
                    whiteSide.add(new LanceBearer(getName(), num, i));
                    darkSide.add(new Robber(getName(), GANG_SIZE - 1 - num, i));
                    break;
            }
        }

        allUnits.addAll(whiteSide);
        allUnits.addAll(darkSide);
        allUnits.sort(new Comparator<ClassUnit>() {
            @Override
            public int compare(ClassUnit u1, ClassUnit u2) {
                if (u2.getSpeed() == u1.getSpeed()) {
                    return (int) u2.getHp() - (int) u1.getHp();
                }
                return u2.getSpeed() - u1.getSpeed();
            }
        });
    }

    private static String getName() {
        return EnumNames.values()[new Random().nextInt(EnumNames.values().length)].toString();
    }

    private static void step() {
        for (ClassUnit unit : allUnits) {
            if (whiteSide.contains(unit)) {
                unit.step(darkSide, whiteSide);
            } else {
                unit.step(whiteSide, darkSide);
            }
        }
    }
}
