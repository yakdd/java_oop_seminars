
import Units.*;
import java.util.Collections;

public class ConsoleView {
    private static int step = 0;
    private static final String top10 = formatDiv("a") + String.join("", Collections.nCopies(9, formatDiv("-b")))
            + formatDiv("-c");
    private static final String mid10 = formatDiv("d") + String.join("", Collections.nCopies(9, formatDiv("-e")))
            + formatDiv("-f");
    private static final String bottom10 = formatDiv("g") + String.join("", Collections.nCopies(9, formatDiv("-h")))
            + formatDiv("-i");

    public static void view() {
        if (step++ == 0) {
            System.out.print(AnsiColors.ANSI_RED + "First step!" + AnsiColors.ANSI_RESET);
            System.out.print(AnsiColors.ANSI_GREEN +
                    String.join("", Collections.nCopies(15, formatDiv(" "))) + "GREEN TEAM:" + AnsiColors.ANSI_RESET);
            System.out.println(AnsiColors.ANSI_BLUE +
                    String.join("", Collections.nCopies(64, formatDiv(" "))) + "BLUE TEAM:" + AnsiColors.ANSI_RESET);
        } else {
            System.out.print(AnsiColors.ANSI_RED + "Step: " + step + AnsiColors.ANSI_RESET);
            System.out.print(AnsiColors.ANSI_GREEN +
                    String.join("", Collections.nCopies(19, formatDiv(" "))) + "GREEN TEAM:" + AnsiColors.ANSI_RESET);
            System.out.println(AnsiColors.ANSI_BLUE +
                    String.join("", Collections.nCopies(64, formatDiv(" "))) + "BLUE TEAM:" + AnsiColors.ANSI_RESET);
        }

        System.out.println(ConsoleView.top10);

        int npcIndex = 0;

        for (int i = 0; i < Main.GANG_SIZE - 1; i++) {
            for (int j = 0; j < Main.GANG_SIZE; j++) {
                System.out.print(getChar(new ClassPosition(j, i)));
            }
            System.out.print("|");
            System.out.println(PrintInfo(npcIndex));
            System.out.println(ConsoleView.mid10);
            npcIndex++;
        }

        for (int j = 0; j <= Main.GANG_SIZE - 1; j++) {
            System.out.print(getChar(new ClassPosition(j, Main.GANG_SIZE - 1)));
        }
        System.out.print("|");
        System.out.println(PrintInfo(npcIndex));
        System.out.println(ConsoleView.bottom10);
    }

    private static String getChar(ClassPosition position) {

        String str = "| ";
        boolean alive = false;
        for (int i = 0; i < Main.GANG_SIZE; i++) {
            if (Main.whiteSide.get(i).getPosition().isEquals(position)) {
                if (Main.whiteSide.get(i).getHp() == 0)
                    str = "|" + AnsiColors.ANSI_RED + Main.whiteSide.get(i).getInfo().toUpperCase().charAt(0)
                            + AnsiColors.ANSI_RESET;
                else {
                    str = "|" + AnsiColors.ANSI_GREEN + Main.whiteSide.get(i).getInfo().toUpperCase().charAt(0)
                            + AnsiColors.ANSI_RESET;
                    alive = true;
                }
            }
            if (Main.darkSide.get(i).getPosition().isEquals(position) && !alive) {
                if (Main.darkSide.get(i).getHp() == 0)
                    str = "|" + AnsiColors.ANSI_RED + Main.darkSide.get(i).getInfo().toUpperCase().charAt(0)
                            + AnsiColors.ANSI_RESET;
                else
                    str = "|" + AnsiColors.ANSI_BLUE + Main.darkSide.get(i).getInfo().toUpperCase().charAt(0)
                            + AnsiColors.ANSI_RESET;
            }
        }
        return str;
    }

    private static String PrintInfo(int npcIndex) {
        String str = "";

        if (Main.whiteSide.get(npcIndex).getHp() == 0)
            str += "     " + AnsiColors.ANSI_RED + Main.whiteSide.get(npcIndex).smileStr() + AnsiColors.ANSI_RESET;
        else
            str += "     " + AnsiColors.ANSI_GREEN + Main.whiteSide.get(npcIndex).smileStr() + AnsiColors.ANSI_RESET;
        if (Main.darkSide.get(npcIndex).getHp() == 0)
            str += "     " + AnsiColors.ANSI_RED + Main.darkSide.get(npcIndex).smileStr() + AnsiColors.ANSI_RESET;
        else
            str += "     " + AnsiColors.ANSI_BLUE + Main.darkSide.get(npcIndex).smileStr() + AnsiColors.ANSI_RESET;

        return str;
    }

    private static String formatDiv(String str) {
        return str.replace('a', '\u250c')
                .replace('b', '\u252c')
                .replace('c', '\u2510')
                .replace('d', '\u251c')
                .replace('e', '\u253c')
                .replace('f', '\u2524')
                .replace('g', '\u2514')
                .replace('h', '\u2534')
                .replace('i', '\u2518')
                .replace('-', '\u2500')
                .replace("s", "...")
                .replace("o", "___");
    }
}