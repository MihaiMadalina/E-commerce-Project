package client;

import java.util.ArrayList;
import java.util.List;

import static client.ClientConsoleReader.insertClientId;


public class ClientService {
    Client client = new Client();
    List<Client> clientList = new ArrayList<Client>();


    public void addClient() {
        clientList.add(ClientConsoleReader.userData());
        ClientConsoleWriter.displayClientData();
    }

    public void deleteClient() {
        for (Client client: clientList){
            if(client.getIdClient()==insertClientId()){
        clientList.remove(client);
        }
    }
    }

    public void editClient(){
        for (Client client: clientList){
            if(client.getIdClient()==insertClientId()){
                ClientConsoleReader.editUserDate();
            }
            else {
                System.out.println("Client not found");
            }
        }
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
