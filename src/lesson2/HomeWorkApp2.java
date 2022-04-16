package lesson2;

public class HomeWorkApp2 {
    public static void main(String[] args) {

        String[] brands = new String[] {"Lenuvo","Asos","Eser","Xamiou"};

        Notebook[] notebook = new Notebook[10000];

        for (int i = 0; i < notebook.length; i++) {

            int price = Math.toIntExact(Math.round(Math.random() * 30)) * 50 + 500;
            int ram = Math.toIntExact(Math.round(Math.random() * 5)) * 4 + 4;
            int brandId = Math.toIntExact(Math.round(Math.random() * 3));
            String brand = brands[brandId];
            notebook[i] = new Notebook(price,ram,brand,brandId);
        }
        System.out.println("Исходный массив ноутбуков: ");
        printNotebooks(notebook);


        sortInsertNoteBook(notebook);
        System.out.println("Массив ноутбуков отсортированный по цене, ОЗУ и марке методом вставки: ");
        printNotebooks(notebook);

        sortSelectPrice(notebook);
        System.out.println("Массив ноутбуков отсортированный только по цене методом выбора (мин и макс): ");
        printNotebooks(notebook);
    }

    private static void printNotebooks(Notebook[] notebook) {
        for (Notebook value : notebook) {
            System.out.println(value.toString());
        }
        System.out.println();
    }


    public static void sortInsertNoteBook(Notebook[] notebook){
        int in, out;

        for(out = 1; out < notebook.length; out++ ) {
            Notebook temp = notebook[out];
            in = out;
            while(in > 0 && notebook[in - 1].getPrice() > temp.getPrice()) {
                notebook[in] = notebook[in - 1];
                in--;
            }
            notebook[in] = temp;
        }
        int from = 1;
        int to = 1;
        for (int i = 1; i < notebook.length; i++) {
            if (notebook[i - 1].getPrice() == notebook[i].getPrice() && i < (notebook.length - 1)) {
                to = i + 1;
            } else {
                for (out = from; out < to; out++) {
                    Notebook temp = notebook[out];
                    in = out;
                    while (in > (from - 1) && notebook[in - 1].getRam() > temp.getRam()) {
                        notebook[in] = notebook[in - 1];
                        in--;
                    }
                    notebook[in] = temp;
                }
                from = to + 1;
                to++;
            }
        }

        from = 1;
        to = 1;
        for (int i = 1; i < notebook.length; i++) {
            if (notebook[i - 1].getRam() == notebook[i].getRam() && i < (notebook.length - 1)) {
                to = i + 1;
            } else {
                for (out = from; out < to; out++) {
                    Notebook temp = notebook[out];
                    in = out;
                    while (in > (from - 1) && notebook[in - 1].getBrandId() > temp.getBrandId()) {
                        notebook[in] = notebook[in - 1];
                        in--;
                    }
                    notebook[in] = temp;
                }
                from = to + 1;
                to++;
            }
        }

    }


    public static void sortSelectPrice(Notebook[] notebook){

        int out, in, minMark, maxMark;

        int to = notebook.length;

        for(out = 0; out < to; out++) {

            minMark = out;
            maxMark = out;

            for(in = out + 1; in < to; in ++) {
                if (notebook[in].getPrice() < notebook[minMark].getPrice()) {
                    minMark = in;
                } else if (notebook[in].getPrice() > notebook[maxMark].getPrice()) {
                    maxMark = in;
                }
            }

            Notebook temp = notebook[out];
            notebook[out] = notebook[minMark];
            notebook[minMark] = temp;

            temp = notebook[notebook.length - out - 1];
            notebook[notebook.length - out - 1] = notebook[maxMark];
            notebook[maxMark] = temp;

            to--;


        }
    }


}
