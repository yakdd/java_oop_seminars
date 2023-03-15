package Units;

public class ClassPosition {
    protected int x, y;

    public static String[][] gameBoard = new String[10][10];

    public static String[][] fillGameBoard() {
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard.length; j++)
                gameBoard[i][j] = " . ";
        }
        return gameBoard;
    }

    public ClassPosition(int x, int y, String typeUnit) {
        this.x = x;
        this.y = y;
        gameBoard[y][x] = " " + typeUnit.charAt(0) + " ";
    }

    public double getDistance(ClassUnit unit) {
        return Math.sqrt(Math.pow(this.x - unit.position.x, 2) + Math.pow(this.y - unit.position.y, 2));
    }

    public static void printGameBoard() {
        System.out.println("\n------------------------------------------------------------");
        System.out.println("Team_1: P - Peasant, W - Wizard, S - Sniper, R - Robber.");
        System.out.println("Team_2: P - Peasant, M - Monk, X - Xbowman, L - LanceBearer.");
        System.out.println("------------------------------------------------------------");

        for (int i = gameBoard.length - 1; i >= 0; i--) {
            System.out.printf(" %d |", i);
            for (int j = 0; j < gameBoard.length; j++) {
                System.out.print(gameBoard[i][j]);
            }
            System.out.println();
        }
        System.out.println("   +-----------------------------");
        System.out.print("    ");
        for (int i = 0; i < gameBoard.length; i++) {
            System.out.printf(" %d ", i);
        }
        System.out.println();
    }

}
