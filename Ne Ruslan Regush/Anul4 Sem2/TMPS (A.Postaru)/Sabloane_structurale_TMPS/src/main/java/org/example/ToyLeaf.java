package org.example;

public class ToyLeaf implements ToyComponent {
    private String name;

    public ToyLeaf(String name) {
        this.name = name;
    }

    @Override
    public void play() {
        System.out.println("Playing with " + name);
    }
}
