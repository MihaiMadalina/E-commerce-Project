import product.Product;
import product.ProductConsoleWriter;

import java.util.Scanner;

public class ConsoleMenu {

    public void displayConsoleMenu(){
        System.out.println("Console Menu:");
        System.out.println("1. Products");
        System.out.println("2. Orders");
        System.out.println("3. Clients");
        System.out.println("0. Exit");
        Scanner scanner = new Scanner( System.in );
        int option = scanner.nextInt();
        switch (option) {
            case 1: ProductConsoleWriter.displayMenuProdcuts();
                    break;
            case 2: ProductConsoleWriter.displayMenuOrders();
                    break;
            case 3: ProductConsoleWriter.displayMenuClients();
                    break;
            case 0: System.exit( 0 );
        }
    }
}
