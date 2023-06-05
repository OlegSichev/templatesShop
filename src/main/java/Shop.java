import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Shop { //Single Responsibility Principle (Solid) - класс выполняет только те функции, для которых
    // он логически предназначен
    static final List<SmartPhone> SMARTPHONES = new ArrayList<>();
    static List<SmartPhone> shoppingCart = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    static Scanner strScanner = new Scanner(System.in);

    public static void addProducts(SmartPhone smartPhone) {
        SMARTPHONES.add(smartPhone);
    }

    public static void showMeSmartPhones() {
        System.out.println("Добро пожаловать в магазин смартфонов! У нас имеется:");
        SMARTPHONES.forEach(System.out::println);
        System.out.println("Введите название смартфона, который вы хотите приобрести:");
        String nameSmart = strScanner.nextLine();
        buy(nameSmart);

    }

    public static SmartPhone searchName(String nameSmartPhone) {
        for (SmartPhone smartPhone : SMARTPHONES) {
            if (nameSmartPhone.equals(smartPhone.name)) {
                return smartPhone;
            }
        }
        System.out.println("Такого смартфона у нас нет!");
        return null;
    }

    public static List<SmartPhone> searchMinMaxPrice(int minPrice, int maxPrice) {
        List<SmartPhone>minMax = new ArrayList<>();
        for (int i = minPrice; i <= maxPrice; i++) { //Мы берем числа НЕ из головы, а ставим минимальное и
            // макисмальное значение из параметров метода, что сразу ясно другому программисту по названиям.
            // Это НЕ магические числа
            for (SmartPhone smartPhone : SMARTPHONES) {
                if (i == smartPhone.price) {
                    minMax.add(smartPhone);
                }
            }
        }
        return minMax;
    }

    public static void buy(String name) {
        SmartPhone smartPhone = searchName(name); //Принцип DRY - как для отдельного поиска смартфона, так
        // и при покупке, Мы используем поиск по имени, потому код был выделен в отдельный метод, а в нужных местах Мы просто вставляем ссылку на нужный нам метод. Никакого 10-ти кратного копирования кода.
        shoppingCart.add(smartPhone);
        System.out.println("Смартфон был успешно добавлен в корзину!\nВ вашей корзине " + shoppingCart.size() + " смартфона.\nДля просмотра каталога нажмите 1, для покупки нажмите 2, для выхода из программы нажмите 3");
        int input = scanner.nextInt();

        switch (input) {
            case 1 -> showMeSmartPhones();
            case 2 -> {
                System.out.println("Покупки отправлены к вам в город\nВаш список покупок: ");
                shoppingCart.forEach(System.out::println);
                System.out.println();
                System.out.println("Общая сумма покупок: " + calcPrice());
            }
            case 3 -> System.exit(0);
        }
    }

    private static int calcPrice(){ //Open Closed Principle - открыт для расширения, но закрыт для модификации
        int sum = 0;
        for (SmartPhone smartPhone : shoppingCart){
            sum += smartPhone.price;
        }
        return sum;
    }
}