package org.example;

import org.example.Toy;

public class ToyAdapter implements Toy {
    private OldToy oldToy;

    public ToyAdapter(OldToy oldToy) {
        this.oldToy = oldToy;
    }

    @Override
    public void play() {
        oldToy.makeNoise();
    }
}
