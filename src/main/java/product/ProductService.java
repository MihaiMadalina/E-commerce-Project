package product;

import java.util.Map;
import java.util.Scanner;

public class ProductService {



    public static Product buyProduct() {

        System.out.println("Alege produsul dorit\n0 - IESIRE sau 99 - Finalizeaza comanda");
        Scanner scanner = new Scanner(System.in);
        Double option = scanner.nextDouble();

        boolean ok = false;
        if (option == 0) {
            System.exit(0);
        } else if (option ==99){userData();}
        for (Product p : ProductFileStorage.productStock.keySet()) { // mergem prin produse
            if (p.getIdProduct() == option) { // daca optiunea corespunde cu codul produsului
                Integer quantity = ProductFileStorage.productStock.get(p); // din stoc luam produsul
                if (quantity > 0) { // daca stocul nu este epuizat
                    ok = true;
                    return p;
                } else {
                    System.out.println("Nu sunt produse suficiente");
                    break;
                }
            }
        }

        if (ok == false) {
            System.out.println("Optiunea introdusa nu este valida");
            return buyProduct(); // recursivitate - te reapelezi pe tine
        }
        return null;
    }

    public static void addToBasket(Product product, Map<Product, Integer> productStock, Map<Product, Integer> productBasket) {
        double total = 0.0;
        productStock.put(product, productStock.get(product) - 1);
        productBasket.put(product, productBasket.get(product)+1);
        System.out.println("Cosul tau contine ");
        System.out.println("Produs\tCantitate\tPret");
        for (Product p : productBasket.keySet()) {
            if(productBasket.get(p)!=0){
                System.out.println(p.getProductName() + "\t " + productBasket.get(p) +"\t "+ p.getPriceProduct() + "$"); }
            total = total + (productBasket.get(p)* p.getPriceProduct());
        }
        System.out.println("Subtotal "+total + "$");
    }

}
