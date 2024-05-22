package org.example;

import org.example.*;
import org.example.*;
import org.example.*;

public class Main {
    public static void main(String[] args) {
        // Observer Pattern
        ToyStore toyStore = new ToyStore();
        ToyObserver observer1 = new ToyObserver(toyStore);
        ToyObserver observer2 = new ToyObserver(toyStore);

        toyStore.setNewToy("Action Figure");
        toyStore.setNewToy("Doll");

        // Strategy Pattern
        Toy toy = new Toy();
        PlayStrategy simplePlay = new SimplePlayStrategy();
        PlayStrategy complexPlay = new ComplexPlayStrategy();

        toy.setPlayStrategy(simplePlay);
        toy.performPlay();

        toy.setPlayStrategy(complexPlay);
        toy.performPlay();

        // Command Pattern
        PlayCommand playCommand = new PlayCommand(toy);
        RemoteControl remoteControl = new RemoteControl();

        remoteControl.setCommand(playCommand);
        remoteControl.pressButton();
    }
}