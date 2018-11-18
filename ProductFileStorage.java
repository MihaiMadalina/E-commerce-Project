package product;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class ProductFileStorage {

    public static Map<Product, Integer> productStock;
    public static Map<Product, Integer> productBasket;

    public void start () {
        while (true) {
            ProductConsoleWriter.displayProducts(ProductFileStorage.productStock); // afisam meniu
            Product product = ProductService.buyProduct(); // selectam produs
            ProductService.addToBasket(product, ProductFileStorage.productStock, ProductFileStorage.productBasket);// livram produsul
        }
    }

    public ProductFileStorage(String filePath) {
        readProductsFromFile(filePath); // call the method initialize
    }

    public void readProductsFromFile (String filePath){

        Path path = Paths.get(filePath); // avoid to use the hard copy of the path in order to specify the location that you want
        List<String> lines = null;

        try {
            lines = Files.readAllLines(path);
        } catch (IOException e) {
            e.printStackTrace();
        }

        productStock = new LinkedHashMap<>();
        productBasket= new LinkedHashMap<>();
        Integer nrProducts = Integer.valueOf(lines.get(0));

        // citeste produsele inclusiv stocurile
        for (int i = 1; i < 1 + nrProducts; i++) { // citeste incepand cu linia de index 1 (produsele)
            String line = lines.get(i);
            String[] parts = line.split(" ");
            Product product = new Product(Double.valueOf(parts[0]), parts[1], parts[2], Double.valueOf(parts[3])); // convertim in integer/string
            productStock.put(product, Integer.valueOf(parts[4])); // pentru a afisa stocul (cantitatea)
            productBasket.put(product, 0);
        }
    }

    public void writeProductsToFile(){

    }

}
