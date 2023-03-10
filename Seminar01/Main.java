import Units.Monk;
import Units.Peasant;
import Units.Robber;
import Units.Sniper;
import Units.Spearman;
import Units.Wizard;
import Units.XBowMan;

public class Main {
    public static void main(String[] args) {
        Peasant peasant = new Peasant();
        Sniper sniper = new Sniper();
        XBowMan xBowMan = new XBowMan();
        Wizard wizard = new Wizard();
        Monk monk = new Monk();
        Robber robber = new Robber();
        Spearman spearman = new Spearman();

        System.out.println("UNITS:");
        System.out.println(peasant);
        System.out.println(sniper);
        System.out.println(xBowMan);
        System.out.println(wizard);
        System.out.println(monk);
        System.out.println(robber);
        System.out.println(spearman);

        System.out.println("-------------------------------");
        sniper.attack(robber); // Снайпер атакует Разбойника
        System.out.println(sniper);
        System.out.println(robber);

        System.out.println("-------------------------------");
        xBowMan.attack(wizard); // Арбалетчик атакует Колдуна
        System.out.println(xBowMan);
        System.out.println(wizard);

        System.out.println();
        wizard.attack(xBowMan); // Колдун атакует Арбалетчика
        System.out.println(wizard);
        System.out.println(xBowMan);

        System.out.println("-------------------------------");
        robber.attack(peasant); // Разбойник атакует Крестьянина
        System.out.println(robber);
        System.out.println(peasant);
    }
}
