package lesson5;

import java.util.ArrayList;
import java.util.List;

public class HomeWorkApp5 {

    public static void main(String[] args) {

        System.out.println("ЗАДАЧА1");

        System.out.println("2 ^ 3 = " + power(2, 3));
        System.out.println("2 ^ (-2) = " + power(2, -2));

        System.out.println();
        System.out.println("ЗАДАЧА2");
        List<Thing> things = new ArrayList<>();
        things.add(new Thing("1", 1.1, 1000));
        things.add(new Thing("2", 2.2, 200));
        things.add(new Thing("3", 3.3, 300));
        things.add(new Thing("4", 4.4, 400));
        things.add(new Thing("5", 5.5, 1000));

        System.out.println("Набор предметов: \n" + things);

        double backpackCapacity  = 5.5;
        System.out.println("Емкость рюкзака: " + backpackCapacity);
        System.out.println("Лучший набор предметов: \n"
                + new Backpack(backpackCapacity, things).bestCombination());

    }

    public static double power(double value, double pow) {
        double result = recursionPower(value, Math.abs(pow));
        return pow < 0 ? 1 / result : result;
    }

    public static double recursionPower(double value, double pow) {
        if (pow == 0) {
            return 1;
        } else {
            return value * recursionPower(value, pow - 1);
        }
    }

}
