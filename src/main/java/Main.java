import product.ProductFileStorage;


public class Main {
    public static void main(String[] args) {
        ProductFileStorage shop = new ProductFileStorage("C:/SDA/shop.txt");
        shop.start();
    }
}
