package ua.en.kosse.oksana.hillel.hw13;

public class HomeWorkFileList {
    public static void main(String[] args) {
        FileNavigator fileNavigator = new FileNavigator();
        FileData fileTest = new FileData("/path/filetest", "test", 10);
        FileData fileTest1 = new FileData("/path/filetest1", "test1", 20);
        FileData fileTest2 = new FileData("/path/filetest1", "test2", 40);
        FileData fileTest3 = new FileData("/path/filetest2", "test1", 30);
        FileData fileTest4 = new FileData("/path/filetest2", "test2", 50);
        FileData fileTest5 = new FileData("/path/filetest3", "test3", 60);

        //2. Реалізувати метод add у класі FileNavigator. Цей метод додає файл за вказаним шляхом.
        // Якщо шлях вже існує, новий файл необхідно додати до списку, вже пов'язаному з відповідним шляхом.
        // ВАЖЛИВО: Шлях – унікальне значення і не повинно повторюватися.

        fileNavigator.add("/path/filetest1", fileTest1);
        fileNavigator.add("/path/filetest1", fileTest2);
        fileNavigator.add("/path/filetest2", fileTest3);
        fileNavigator.add("/path/filetest2", fileTest4);
        fileNavigator.add("/path/filetest3", fileTest5);


        //3. Реалізувати метод find у класі FileNavigator.
        // Метод повертає список файлів, пов'язаних з шляхом переданим як параметр.
        System.out.println("3. ");
        System.out.println("Find /path/filetest1");
        System.out.println(fileNavigator.find("/path/filetest1"));
        System.out.println();
        System.out.println("Find /path/filetest2");
        System.out.println(fileNavigator.find("/path/filetest2"));

        //4. Реалізувати метод filterBySize у класі FileNavigator. Метод повертає список файлів,
        // розмір (в байтах) яких не перевищує значення, передане як параметр.
        System.out.println("4. ");
        System.out.println("FilterBySize <= 30:");
        System.out.println(fileNavigator.filterBySize(30));
        System.out.println();
        System.out.println("FilterBySize <= 50:");
        System.out.println(fileNavigator.filterBySize(50));

        //5. Реалізувати метод remove у класі FileNavigator.
        // Метод видаляє шлях і пов'язані з ним файли, виходячи з значення шляху, переданого як параметр.
        System.out.println("5.");
        System.out.println("SortBySize:");
        System.out.println(fileNavigator.sortBySize());

        //6. * Реалізувати метод sortBySize у класі FileNavigator.
        // Метод сортує всі наявні файли за розміром (за зростанням), потім повертає список відсортованих файлів.
        System.out.println("6.");
        System.out.println("FileNavigator before delete:");
        System.out.println(fileNavigator);
        System.out.println();
        System.out.println("FileNavigator after delete:");
        fileNavigator.remove("/path/filetest2");
        System.out.println(fileNavigator);

        // 7. ** Реалізувати перевірку консистентності у методі add у класі FileNavigator.
        // Не дозволяти додавати значення і повідомити про це в консолі, при спробі додати значення
        // FileData значення шляху якого не відповідає шляху-ключу, що веде до списку файлів.
        System.out.println("7.");
        System.out.println("Add file with invalid path: \"/path/file\"");
        fileNavigator.add("/path/file", fileTest);

    }
}
