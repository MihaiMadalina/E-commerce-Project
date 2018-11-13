import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Shop {
    public Map<Product, Integer> productStock;
    // create constructor
    public Shop(String filePath) {
        this.initialize(filePath); // call the method initialize
    }
    //constructor fara parametru
    public Shop(){}

    public String displayMenu(Map<Product, Integer> productStock){
        String myMenu = "";
        myMenu =  myMenu.concat("Welcome to our shop. Choose the products you like");
        myMenu = myMenu.concat("\n"); // this is a new line
        myMenu = myMenu.concat("Cod\tCategorie\tProdus\t Pret");
        myMenu = myMenu.concat("\n"); // this is a new line
        for (Product product : productStock.keySet()) {
            myMenu =  myMenu.concat(product.getIdProduct()+"\t"+ product.getCategoryName()+"\t"+ product.getProductName()+"\t"+ product.getPriceProduct());
            myMenu =  myMenu.concat("\n");
        }
        System.out.println(myMenu);
        return myMenu;
    }

    public void start(){
        while(true) {
            this.displayMenu(productStock); // afisam meniu
//            Product product = this.buyProduct(); // selectam produs
//            this.displayCoinsStock(coinStock); // afisam monezi
//            Integer sum = this.insertCoins(product.getPrice(), coinStock); // primim o suma pe care am introdus-o
//            this.deliverProduct(product, productStock); // livram produsul
//            this.payRest(sum - product.getPrice()); // dam rest scazand din suma introdusa pretul produsului
            break;
        }

    }

    // cream o metoda de initializare a fisierului de proprietati
    public void initialize(String filePath){

        Path path = Paths.get(filePath); // avoid to use the hard copy of the path in order to specify the location that you want
        List<String> lines = null;

        try {
            lines = Files.readAllLines(path);
        } catch (IOException e) {
            e.printStackTrace();
        }


        productStock = new LinkedHashMap<>();
        Integer nrProducts = Integer.valueOf(lines.get(0));

        // citeste produsele inclusiv stocurile
        for (int i = 1; i < 1+nrProducts; i++) { // citeste incepand cu linia de index 3 (produsele)
            String line = lines.get(i);
            String[] parts = line.split(" ");
            Product product = new Product(Double.valueOf(parts[0]),parts[1], parts[2], Double.valueOf(parts[3])); // convertim in integer/string
            productStock.put(product, Integer.valueOf(parts[4])); // pentru a afisa stocul (cantitatea)
        }
    }
}

