//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.io.*;
import java.net.*;

public class HtmlRequestClient {
    public static void main(String[] args) {
        String hostname = "localhost"; // Adresa IP a serverului nostru
        int port = 6000; // Portul pe care serverul ascultă

        try (Socket socket = new Socket(hostname, port);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))) {

            // Trimite o cerere serverului
            out.println("GET / HTTP/1.1");

            // Citește răspunsul serverului
            String serverResponse;
            while ((serverResponse = in.readLine()) != null) {
                System.out.println(serverResponse);
            }
        } catch (UnknownHostException e) {
            System.out.println("Server necunoscut: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Eroare I/O: " + e.getMessage());
        }
    }
}