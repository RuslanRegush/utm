package org.example;

import org.example.OldToy;
import org.example.ToyAdapter;
import org.example.ToyComposite;
import org.example.ToyComponent;
import org.example.ToyLeaf;
import org.example.BasicToy;
import org.example.MusicalToy;
import org.example.Toy;

public class Main {
    public static void main(String[] args) {
        // Decorator Pattern
        Toy basicToy = new BasicToy();
        Toy musicalToy = new MusicalToy(basicToy);

        System.out.println("Decorator Pattern:");
        basicToy.play();
        musicalToy.play();

        // Adapter Pattern
        OldToy oldToy = new OldToy();
        Toy adaptedToy = new ToyAdapter(oldToy);

        System.out.println("\nAdapter Pattern:");
        adaptedToy.play();

        // Composite Pattern
        ToyComponent toy1 = new ToyLeaf("Toy 1");
        ToyComponent toy2 = new ToyLeaf("Toy 2");
        ToyComponent toy3 = new ToyLeaf("Toy 3");

        ToyComposite compositeToy = new ToyComposite();
        compositeToy.add(toy1);
        compositeToy.add(toy2);
        compositeToy.add(toy3);

        System.out.println("\nComposite Pattern:");
        compositeToy.play();
    }
}