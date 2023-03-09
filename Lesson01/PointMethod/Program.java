package PointMethod;

public class Program {
    public static void main(String[] args) {

        Point2D a = new Point2D();
        Point2D b = new Point2D(1, 1);
        Point2D c = new Point2D(5);
        System.out.println(a.getInfo());

        a.setX(11);
        System.out.println(a.getX());
        System.out.println(a.getY());

        // System.out.println(a);
        // System.out.println(b);
        // System.out.println(c);

        // System.out.println("A: " + a.getInfo());
        // System.out.println("B: " + b.getInfo());
        // System.out.println("C: " + c.getInfo());
        // метод класса getInfo() будет доступен здесь,
        // если в классе он помечен как public или protected (модифиу=катор доступа)
        // и недоступен, если как private

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);

        System.out.println("Расстояние между точками A и B = " + Point2D.distance(a, b));
    }
}
