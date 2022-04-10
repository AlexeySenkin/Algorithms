package lesson3;

import java.util.Arrays;

public class HomeWorkApp3 {
    public static void main(String[] args) {

        System.out.println("\nЗАДАЧА 1:");

        int[] values  = new int[] {1,2,3,4,5,  7,8,9,10};
        int[] values1 = new int[] {1,2,3,4,5,6,7,8,  10};
        int[] values2 = new int[] {1,  3,4,5,6,7,8,9,10};
        int[] values3 = new int[] {  2,3,4,5,6,7,8,9,10};
        int[] values4 = new int[] {1,2,3,4,5,6,7,8,9,10};
        int[] values5 = new int[] {};

        System.out.println("Массив " + Arrays.toString(values)  + ". Пропущенное значение: " + binaryFindLostValue(values));
        System.out.println("Массив " + Arrays.toString(values1) + ". Пропущенное значение: " + binaryFindLostValue(values1));
        System.out.println("Массив " + Arrays.toString(values2) + ". Пропущенное значение: " + binaryFindLostValue(values2));
        System.out.println("Массив " + Arrays.toString(values3) + ". Пропущенное значение: " + binaryFindLostValue(values3));
        System.out.println("Массив " + Arrays.toString(values4) + ". Пропущенное значение: " + binaryFindLostValue(values4));
        System.out.println("Массив " + Arrays.toString(values5) + ". Пропущенное значение: " + binaryFindLostValue(values5));


        System.out.println("\nЗАДАЧА 2:");
        int queueSize = 5;

        Queue queue = new Queue(queueSize);

        for (int i = 1; i <= queueSize; i++) {
            if (!queue.insert(i)) {
                System.out.println("В очереди нет места!");
            }
        }
        System.out.print("Исходная очередь: ");
        queue.print();

        System.out.print("\nДобавление элементов: ");
        if (!queue.insert(6)) {
            System.out.print("В очереди нет места!");
        }

        System.out.print("\nУдаление элементов: ");
//        while( !queue.isEmpty() ) {
//            queue.remove();
//            queue.print();
//        }
        if (!queue.isEmpty()) {
            queue.remove();
            queue.print();
        }
        if (!queue.isEmpty()) {
            queue.remove();
            queue.print();
        }

        System.out.print("\nДобавление элементов: ");
        if (!queue.insert(6)) {
            System.out.print("В очереди нет места!");
        }
        queue.print();
        if (!queue.insert(7)) {
            System.out.print("В очереди нет места!");
        }
        queue.print();
    }

    public static int binaryFindLostValue(int[] values){
        if (values.length == 0) {
            return 1;
        }
        if (values[values.length - 1] - (values.length - 1) == 1) {
            return values[values.length - 1] + 1;
        }
        int low = 0;
        int high = values.length - 1;
        int mid;
        while(low <= high) {
            mid = (low + high) / 2;
            if (values[mid] - mid == 1) {
                if (values[mid + 1] - (mid + 1) > 1) {
                  return values[mid] + 1;
                } else {
                    low = mid + 1;
                }
            } else {
                high = mid - 1;
            }
        }
        return 1;
    }



}
