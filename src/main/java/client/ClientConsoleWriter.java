package client;

public class ClientConsoleWriter {
    Client client = new Client();
    public void displayUserData(){
        System.out.println("Datele tale sunt " + client.getFirstName() + " " + client.getLastName() + " " +
                client.getAddress() + " " + client.getEmail() + " " + client.getPhone());
    }
}
