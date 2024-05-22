package org.example;

public class Toy {
    private PlayStrategy playStrategy;

    public void setPlayStrategy(PlayStrategy playStrategy) {
        this.playStrategy = playStrategy;
    }

    public void performPlay() {
        playStrategy.play();
    }
}
