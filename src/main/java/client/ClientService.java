package client;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ClientService {
    Client client = new Client();
    List<Client> clientList = new ArrayList<Client>();


    public void addClient() {
        clientList.add(client);
    }

    public void deleteClient() {
        clientList.remove(client);
    }

    public String displayClientList(List<Client>clientList) {
        String myClients = "";
        myClients = myClients.concat("My list contains the following clients:");
        myClients = myClients.concat("\n"); // this is a new line
        myClients = myClients.concat("idClient \t First name \t Last name\t Address \t Email address \t Contact number");
        myClients = myClients.concat("\n"); // this is a new line
        for (Client client : clientList) {
            myClients = myClients.concat(client.getIdClient() + "\t" + client.getFirstName()
                    + "\t" + client.getLastName() + "\t" + client.getAddress() + "\t" + client.getEmail() + "\t" + client.getPhone());
            myClients = myClients.concat("\n");
        }
        System.out.println(myClients);
        return myClients;
    }

    public void deleteAllClientList() {
        clientList.removeAll(clientList);
    }
}
