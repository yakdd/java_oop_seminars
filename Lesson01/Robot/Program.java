package Robot;

public class Program {
    public static void main(String[] args) {
        System.out.println();

        Robot robot = new Robot("Roboto");
        System.out.println("---------------------------");
        System.out.println(robot);
        robot.power();
        robot.work();
        robot.power();
        robot.work();

        robot.power();
    }
}
