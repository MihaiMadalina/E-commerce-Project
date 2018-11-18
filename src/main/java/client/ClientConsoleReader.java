package client;

import java.util.Scanner;

public class ClientConsoleReader {

    public static Client userData(){
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
        return client;

    }

    public static int insertClientId(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Alege ID-ul produsului pe care vrei sa-l stergi");
        int clientId = scanner.nextInt();
        return clientId;
    }

    public static Client editUserDate(){
        Client client = new Client();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Editeaza datele utilizatorului");
        System.out.println("Edit first name");
        client.setFirstName(scanner.nextLine());
        System.out.println("Edit last name");
        client.setLastName(scanner.nextLine());
        System.out.println("Edit address");
        client.setAddress(scanner.nextLine());
        System.out.println("Edit email");
        client.setEmail(scanner.nextLine());
        System.out.println("Edit phone");
        client.setPhone(scanner.nextInt());
        return client;
    }



    public static void insertBankAccount(){
        Client client = new Client();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ai ales sa platesti cu cardul. Introdu datele contului tau bancar");
        client.setBankAccount(scanner.nextLine());
    }
}
