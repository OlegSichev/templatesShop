public class SmartPhone implements Products {
    String name;
    int price;


    public SmartPhone(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return this.name + " - " + this.price + " рублей";
    }
}
