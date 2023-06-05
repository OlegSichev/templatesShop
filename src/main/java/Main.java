import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Shop.addProducts("Nokia", 5_000);
        Shop.addProducts("Iphone 14", 90_000);
        Shop.addProducts("Samsung galaxy s23", 80_000);
        Shop.addProducts("Xiaomi note 10 pro", 20_000);
        Shop.showMeProducts();
    }
}
