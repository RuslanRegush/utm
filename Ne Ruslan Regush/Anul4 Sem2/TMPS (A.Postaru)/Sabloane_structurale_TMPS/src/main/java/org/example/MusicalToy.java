package org.example;

public class MusicalToy extends ToyDecorator {

    public MusicalToy(Toy decoratedToy) {
        super(decoratedToy);
    }

    @Override
    public void play() {
        decoratedToy.play();
        setMusic(decoratedToy);
    }

    private void setMusic(Toy decoratedToy) {
        System.out.println("Playing music from the toy.");
    }
}
