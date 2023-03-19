package Units;

public class ClassPosition {
    protected int x, y;

    public ClassPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean isEquals(ClassPosition opposist) {
        if (opposist.x == this.x && opposist.y == this.y)
            return true;
        return false;
    }

    public double getDistance(ClassUnit unit) {
        return Math.sqrt(Math.pow(this.x - unit.position.x, 2) + Math.pow(this.y - unit.position.y, 2));
    }
}
