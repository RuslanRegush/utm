package org.example;

import org.example.Toy;

public class PlayCommand implements Command {
    private Toy toy;

    public PlayCommand(Toy toy) {
        this.toy = toy;
    }

    @Override
    public void execute() {
        toy.performPlay();
    }
}
