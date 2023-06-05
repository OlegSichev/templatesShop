import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Shop {
    static final List<Product>SMARTPHONES = new ArrayList<>();
    static Map<String, Integer>productsAndPrice = new HashMap<>();

    public static void addProducts(String name, int price){
        int numberName = productsAndPrice.size() + 1;
        String number = Integer.toString(numberName) + ". ";
        name = number + name;
        productsAndPrice.put(name, price);
    }

    public static void showMeProducts(){
        System.out.println("Добро пожаловать в магазин смартфонов!\nУ нас имеется:");
        for(Map.Entry<String,Integer> kv : productsAndPrice.entrySet()){
            System.out.println("Смартфон " + kv.getKey() + " - " + kv.getValue() + " рублей");
        }
    }

    public static Product searchProductName(String nameProduct){
        return new Product(nameProduct, productsAndPrice.get(nameProduct));
    }

    public static Product searchPrice(int price){
        for(Map.Entry<String,Integer> kv : productsAndPrice.entrySet()){
            if (kv.getValue() == price){
                return new Product(kv.getKey(), kv.getValue());
            } else {
                System.out.println("Ничего не найдено");
            }
        }
        return null;
    }

    public static Product searchPriceMinMax(int minPrice, int maxPrice){
        for (int i = minPrice; i <= maxPrice; i++) {
            for(Map.Entry<String,Integer> kv : productsAndPrice.entrySet()){
                if (kv.getValue() == i){
                    return new Product(kv.getKey(), kv.getValue());
                } else {
                    System.out.println("Ничего не найдено");
                }
            }
        }
        return null;
    }


    public static void shoppingCart(Product product){
        SMARTPHONES.add(product);
    }
}
