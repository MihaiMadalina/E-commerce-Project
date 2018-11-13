import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Shop {
    public Map<Product, Integer> productStock;
    public Map<Product, Integer> productBasket = new LinkedHashMap<>();
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

    // create a method fro buying products
    public Product buyProduct(){

        System.out.println("Choose the product you want:");
        Scanner scanner = new Scanner(System.in);
        Double option = scanner.nextDouble();

        boolean ok = false;
        if(option == 0){
            System.exit(0);
        }
        for (Product p : productStock.keySet()) { // mergem prin produse
            if(p.getIdProduct() == option){ // daca optiunea corespunde cu codul produsului
                Integer quantity = productStock.get(p); // din stoc luam produsul
                if(quantity > 0){ // daca stocul nu este epuizat
                    ok = true;
                    return p;
                    //productStock.put(p,quantity-1); // suprascriere
                    //   System.out.println("Produs cumparat cu succes.");
                } else {
                    System.out.println("Nu sunt produse suficiente");
                    break;
                }
            }
        }

        if(ok == false){
            System.out.println("Optiunea introdusa nu este valida");
            return this.buyProduct(); // recursivitate - te reapelezi pe tine
        }
        return null;
    }

    // scadem produsul din stoc
    public void addToBasket(Product product, Map<Product, Integer> productStock, Map<Product, Integer> productBasket){
        productStock.put(product, productStock.get(product) - 1);
        productBasket.put(product, productBasket.get(product) + 1);
        System.out.println("Your basket contains " + productBasket);
    }



    public void start(){
        while(true) {
            this.displayMenu(productStock); // afisam meniu
            Product product = this.buyProduct(); // selectam produs
            this.addToBasket(product, productStock, productBasket); // livram produsul
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

