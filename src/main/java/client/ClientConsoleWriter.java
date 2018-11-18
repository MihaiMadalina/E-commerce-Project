package client;

import java.util.Scanner;

public class ClientConsoleWriter {

    public static void displayClientData(){
        Client client = new Client();
        System.out.println("Datele tale clientului " + client.getFirstName() + " " + client.getLastName() + " " +
                client.getAddress() + " " + client.getEmail() + " " + client.getPhone());
    }

    public static void displayMenuClients(){
        System.out.println("1. Display client menu");
        System.out.println("2. Add client");
        System.out.println("3.Edit client");
        System.out.println("4.Delete client");
        System.out.println("0 - Exit");
        System.out.println("Select your option");
        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();
        switch (option){
            case 1: 
        }
    }
}
