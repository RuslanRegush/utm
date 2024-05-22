package org.example;
public class DatabaseConnection {
    private static DatabaseConnection instance;

    private DatabaseConnection() {
        // Conexiune la baza de date
    }

    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    public void connect() {
        System.out.println("Conectat la baza de date.");
    }
}
