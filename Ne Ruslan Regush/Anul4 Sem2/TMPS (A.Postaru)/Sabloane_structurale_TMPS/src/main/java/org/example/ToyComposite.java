package org.example;

import java.util.ArrayList;
import java.util.List;

public class ToyComposite implements ToyComponent {
    private List<ToyComponent> toys = new ArrayList<>();

    public void add(ToyComponent toy) {
        toys.add(toy);
    }

    public void remove(ToyComponent toy) {
        toys.remove(toy);
    }

    @Override
    public void play() {
        for (ToyComponent toy : toys) {
            toy.play();
        }
    }
}
