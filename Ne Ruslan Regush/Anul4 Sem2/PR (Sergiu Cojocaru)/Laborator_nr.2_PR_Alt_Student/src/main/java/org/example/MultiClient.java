package org.example;
import java.io.*;
import java.net.*;

public class MultiClient {
    public static void main(String[] args) {
        String hostname = "localhost";
        int port = 5000;

        try (Socket socket = new Socket(hostname, port);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))) {

            String userInput;
            System.out.println("Introduceți mesajele pentru server (scrie 'exit' pentru a ieși):");

            while ((userInput = stdIn.readLine()) != null) {
                if ("exit".equalsIgnoreCase(userInput)) {
                    break;
                }
                out.println(userInput);
                String response = in.readLine();
                System.out.println("Răspuns de la server: " + response);
            }
        } catch (UnknownHostException e) {
            System.out.println("Server necunoscut: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Eroare I/O: " + e.getMessage());
        }
    }
}