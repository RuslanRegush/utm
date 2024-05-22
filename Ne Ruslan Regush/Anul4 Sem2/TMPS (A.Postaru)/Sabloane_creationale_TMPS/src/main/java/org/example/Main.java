package org.example;
public class Main {
    public static void main(String[] args) {
        // Utilizarea Singleton
        DatabaseConnection connection = DatabaseConnection.getInstance();
        connection.connect();

        // Utilizarea Factory Method
        Creator creatorA = new ConcreteCreatorA();
        creatorA.operation();

        Creator creatorB = new ConcreteCreatorB();
        creatorB.operation();

        // Utilizarea Builder
        Builder builder = new ConcreteBuilder();
        Director director = new Director(builder);
        director.construct();
        Factory_Method_Pattern product = builder.getResult();
        System.out.println(product);
    }
}