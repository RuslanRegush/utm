package org.example;

public abstract class ToyDecorator implements Toy {
    protected Toy decoratedToy;

    public ToyDecorator(Toy decoratedToy) {
        this.decoratedToy = decoratedToy;
    }

    public void play() {
        decoratedToy.play();
    }
}