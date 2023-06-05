import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static Scanner strScan = new Scanner(System.in);

    public static void main(String[] args) {
        Shop.addProducts(new SmartPhone("Nokia", 5_000));
        Shop.addProducts(new SmartPhone("Iphone", 90_000));
        Shop.addProducts(new SmartPhone("Samsung", 100_000));
        Shop.addProducts(new SmartPhone("Huawei", 30_000));

        Products xiaomi = new SmartPhone("Xiaomi", 3000); //D - (Dependency Inversion Principle)
        // Всё зависит от абстракций (интерфейсов), а не от деталей реализации друг друга. (Liskov Substitution Principle)
        //Наследуй только тогда, когда можешь играть роль за предка. - и то, и то является продуктов, значит, может
        // играть роль друг друга. Интерфейс Products у меня пустой и без методов, чисто, что б показать понимание принципа.



        System.out.println("Добро пожаловать в интернет-магазин смартфонов\nДля открытия каталога смартфонов нажмите 1." +
                "\nДля открытия поиска по минимальной и максимальной цене - нажмите 2.\nДля выхода - нажмите 3.");
        int input = scanner.nextInt();
        switch (input){
            case 1 -> Shop.showMeSmartPhones();
            case 2 -> {
                System.out.println("Введите минимальную цену:");
                int min = scanner.nextInt();
                System.out.println("Введите максимальную цену:");
                int max = scanner.nextInt();
                List<SmartPhone> smartPhone = Shop.searchMinMaxPrice(min, max);
                System.out.println("По вашему запросу найдены следующие смартфоны:");
                smartPhone.forEach(System.out::println);
                System.out.println();
                System.out.println("Введите название смартфона для покупки:");
                Shop.buy(strScan.nextLine());
            }
            case 3 -> System.exit(0);
        }

        System.out.println();
    }
}
