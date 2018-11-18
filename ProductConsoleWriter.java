package product;

import java.util.Map;
import java.util.Scanner;

public class ProductConsoleWriter {

    public static void displayMenuProducts(){
        System.out.println("1. Add product");
        System.out.println("2. Remove product");
        System.out.println("3. Update product");
        System.out.println("0. Exit");
        Scanner scanner = new Scanner( System.in );
        int option = scanner.nextInt();
        switch (option) {
            case 1: ProductService.addProduct( new Product( 1.7, "Laptop",
                    "laptop cu...", 1200 ) );
                break;
            case 2: ProductService.removeProduct( new Product( 1.7, "Laptop",
                    "laptop cu...", 1200 ) );
                break;
            case 3: ProductService.updateProduct(  );
                break;
            case 0: System.exit( 0 );
        }
    }

    public static String displayProducts(Map<Product, Integer> productStock) {
        String myMenu = "";
        myMenu = myMenu.concat("Bine ai venit. Alege produsul dorit.\n0 - IESIRE sau 99 - Finalizeaza comanda");
        myMenu = myMenu.concat("\n"); // this is a new line
        myMenu = myMenu.concat("Cod\tCategorie\tProdus\t Pret");
        myMenu = myMenu.concat("\n"); // this is a new line
        for (Product product : productStock.keySet()) {
            myMenu = myMenu.concat(product.getIdProduct() + "\t" + product.getCategoryName() + "\t" + product.getProductName() + "\t" + product.getPriceProduct());
            myMenu = myMenu.concat("\n");
        }
        System.out.println(myMenu);
        return myMenu;
    }

    public static StringBuilder displayProduct(Map<Product, Integer> productStock, double idProduct){
        StringBuilder updateMenu = new StringBuilder(  );
        updateMenu = updateMenu.append(  "Category Name\tProductName\tPrice Product\tStock Product");
        updateMenu = updateMenu.append( "\n" );
        for (Product product : productStock.keySet()) {
            if (product.getIdProduct() == idProduct){
                updateMenu = updateMenu.append( product.getCategoryName() + "\t" +
                        product.getProductName() + "\t" + product.getPriceProduct() + "\t" +
                        productStock.get( product ));
            }
        }
        return updateMenu;
    }

}
