package product;

import client.ClientConsoleReader;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ProductService {

    Product product = new Product();
    private static List<Product> productList = new LinkedList<Product>(  );

    public static void addProduct(Product product){
        productList.add( product );
    }

    public static void removeProduct(Product product){
        productList.remove( product );
    }

    public static void updateProduct(Map<Product, Integer> productStock){
        // type idProduct to modify
        Scanner scanner = new Scanner( System.in );
        System.out.print("Type product id: ");
        double findIdProduct = scanner.nextDouble();

        for (Product product : productStock.keySet()){
            if (product.getIdProduct() == findIdProduct){
                ProductConsoleWriter.displayProduct(productStock, findIdProduct);
                // type new values for Price and Stoc Product
                System.out.print("Type new Price for Product:");
                double newProductPrice = scanner.nextDouble();
                System.out.print("Type new Stock for Product:");
                int newProductStock = scanner.nextInt();
                product.setPriceProduct(newProductPrice);
                productStock.put( product, newProductStock );
                ProductConsoleWriter.displayProduct(productStock, findIdProduct);
            }
        }
    }

    public static void deleteAllClientList() {
        productList.removeAll(productList);
    }


    public static Product buyProduct() {

        System.out.println("Alege produsul dorit\n0 - IESIRE sau 99 - Finalizeaza comanda");
        Scanner scanner = new Scanner(System.in);
        Double option = scanner.nextDouble();

        boolean ok = false;
        if (option == 0) {
            System.exit(0);
        } else if (option ==99) {
            ClientConsoleReader.userData();
        }
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
