package Robot;

import java.util.ArrayList;

public class Robot {
    enum State {
        On, Off
    }

    private static int defaultIndex;
    private static ArrayList<String> names;

    static {
        defaultIndex = 1;
        names = new ArrayList<String>();
    }

    /** уровень робота */
    private int level;
    /** имя робота */
    private String name;
    private State state;

    /**
     * Создание робота
     * 
     * @param name  - Имя робота !Не должно начинаться с цифры
     * @param level - Уровень робота
     */
    private Robot(String name, int level) {
        System.out.println(Character.isDigit(name.charAt(0)));
        if ((name.isEmpty() // пустое
                || Character.isDigit(name.charAt(0))) // начинается с цифры
                || Robot.names.indexOf(name) != -1) // уже есть в сиске
        {
            this.name = String.format("DefaultName_%d", defaultIndex++);
        } else
            this.name = name;
        Robot.names.add(this.name);

        this.level = level;
        this.state = State.Off;
    }

    public Robot(String name) {
        this(name, 1);
    }

    public Robot() {
        this("");
    }

    // Методы вкл/выкл подсистем

    public void power() {
        if (this.state == State.Off) {
            this.powerOn();
            this.state = State.On;
        } else {
            this.powerOff();
            this.state = State.Off;
        }
        System.out.println();
    }

    private void powerOn() {
        this.startBIOS();
        this.startOS();
        this.sayHi();
    }

    private void powerOff() {
        this.sayBye();
        this.stopOS();
        this.stopBIOS();
    }

    public int getLevel() {
        return this.level;
    }

    public String getName() {
        return this.name;
    }

    private void startBIOS() {
        System.out.println("Start BIOS...");
    }

    private void startOS() {
        System.out.println("Start OS...");
    }

    private void sayHi() {
        System.out.println("Hello world...");
    }

    private void stopBIOS() {
        System.out.println("Stop BIOS...");
    }

    private void stopOS() {
        System.out.println("Stop OS...");
    }

    private void sayBye() {
        System.out.println("Bye...");
    }

    public void work() {
        if (this.state == State.On) {
            System.out.println("Working...");
        }
    }

    @Override
    public String toString() {
        return String.format("%s %d\n", this.name, this.level);
    }

}
