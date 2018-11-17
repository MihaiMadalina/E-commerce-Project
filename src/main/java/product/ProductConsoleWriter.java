package product;

import java.util.Map;

public class ProductConsoleWriter {

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

}
