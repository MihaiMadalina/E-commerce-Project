package client;

import java.util.Scanner;

public class ClientConsoleReader {

    public static void userData(){
        Client client = new Client();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ai ales sa finalizezi comanda.\nCompleteaza datele personale");
        System.out.println("Prenume");
        client.setFirstName(scanner.nextLine());
        System.out.println("Nume");
        client.setLastName(scanner.nextLine());
        System.out.println("Adresa");
        client.setAddress(scanner.nextLine());
        System.out.println("Email");
        client.setAddress(scanner.nextLine());
        System.out.println("Telefon");
        client.setPhone(scanner.nextInt());

    }

    public static void insertBankAccount(){
        Client client = new Client();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ai ales sa platesti cu cardul. Introdu datele contului tau bancar");
        client.setBankAccount(scanner.nextLine());
    }
}
