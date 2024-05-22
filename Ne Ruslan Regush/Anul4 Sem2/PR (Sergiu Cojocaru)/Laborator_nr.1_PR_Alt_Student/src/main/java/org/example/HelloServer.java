package org.example;
import java.io.*;
import java.net.*;

public class HelloServer {
    public static void main(String[] args) {
        int port = 5000;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Serverul ascultă pe portul " + port);

            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

                    String clientMessage = in.readLine();
                    String[] parts = clientMessage.split(" ");
                    if (parts.length == 2) {
                        String nume = parts[0];
                        String prenume = parts[1];
                        String response = "Salut " + nume + " " + prenume;
                        out.println(response);
                    } else {
                        out.println("Mesaj invalid. Trimite Nume Prenume.");
                    }
                } catch (IOException e) {
                    System.out.println("Eroare în comunicarea cu clientul: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("Eroare la pornirea serverului: " + e.getMessage());
        }
    }
}
