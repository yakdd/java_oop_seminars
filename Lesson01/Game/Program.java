package Game;

import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class Program {
    public static void main(String[] args) {

        int teamCount = 10;
        Random rand = new Random();
        int magicainCount = 0;
        int priestCount = 0;

        List<BaseHero> teams = new ArrayList<>();
        for (int i = 0; i < teamCount; i++) {
            if (rand.nextInt(2) == 0) {
                teams.add(new Priest());
                priestCount++;
            } else {
                teams.add(new Magician());
                magicainCount++;
            }

            System.out.println(teams.get(i).getInfo());
        }
        System.out.println();
        System.out.printf("Magicians: %d. Priests: %d", magicainCount, priestCount);
    }
}
