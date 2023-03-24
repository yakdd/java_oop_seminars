package Units;

import java.util.ArrayList;

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

    public Object getTarget(ArrayList<ClassUnit> enemy) {
        /**
         * Функция возвращает ClassUnit если найдена живая цель, либо null
         */
        ClassUnit target = null;

        for (ClassUnit unit1 : enemy) {
            if (unit1.hp > 0) {
                target = unit1;
                double minDistance = getDistance(target);
                for (ClassUnit unit : enemy) {
                    if (unit.hp > 0) {
                        double unitDistance = getDistance(unit);
                        if (unitDistance < minDistance) {
                            minDistance = unitDistance;
                            target = unit;
                        }
                    }
                }
                break;
            }
        }
        return target;
    }

    public double getDistance(ClassUnit unit) {
        return Math.sqrt(Math.pow(this.x - unit.position.x, 2) + Math.pow(this.y - unit.position.y, 2));
    }

    public void getDirection(ClassPosition target, ArrayList<ClassUnit> friends) {
        boolean[] temp = checkNextDoor(friends);

        int dx = Math.abs(this.x - target.x);
        int dy = Math.abs(this.y - target.y);

        // выбор хода по горизонтали или по вертикали:
        boolean horizontal = false;
        boolean vertical = false;
        if (dx >= dy && temp[0] == false)
            horizontal = true;
        if (dx <= dy && temp[1] == false)
            vertical = true;

        if (horizontal) {
            if (this.x > target.x)
                this.x -= 1;
            else
                this.x += 1;
        } else if (vertical) {
            if (this.y > target.y)
                this.y -= 1;
            else
                this.y += 1;
        }
    }

    public boolean[] checkNextDoor(ArrayList<ClassUnit> friends) {
        boolean[] temp = new boolean[2];
        Object neighbour = getTarget(friends);
        if (neighbour instanceof ClassUnit) {
            ClassUnit neighbourunit = (ClassUnit) neighbour;
            if ((this.x + 1 == neighbourunit.position.x) || (this.x - 1 == neighbourunit.position.x))
                temp[0] = true;
            if ((this.y + 1 == neighbourunit.position.y) || (this.y - 1 == neighbourunit.position.y))
                temp[1] = true;
        }
        return temp;
    }
}
