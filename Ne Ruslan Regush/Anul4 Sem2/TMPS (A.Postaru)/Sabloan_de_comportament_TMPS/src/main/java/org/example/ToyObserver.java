package org.example;

public class ToyObserver implements Observer {
    private ToyStore toyStore;

    public ToyObserver(ToyStore toyStore) {
        this.toyStore = toyStore;
        this.toyStore.addObserver(this);
    }

    @Override
    public void update() {
        System.out.println("New toy arrived: " + toyStore.getNewToy());
    }
}
