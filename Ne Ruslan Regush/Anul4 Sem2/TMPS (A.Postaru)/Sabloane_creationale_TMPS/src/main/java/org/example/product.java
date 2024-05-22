package org.example;

class Factory_Method_Pattern {
    private String partA;
    private String partB;

    public void setPartA(String partA) {
        this.partA = partA;
    }

    public void setPartB(String partB) {
        this.partB = partB;
    }

    @Override
    public String toString() {
        return "Product [partA=" + partA + ", partB=" + partB + "]";
    }
}

abstract class Builder {
    protected Factory_Method_Pattern product = new Factory_Method_Pattern();

    public abstract void buildPartA();
    public abstract void buildPartB();
    public Factory_Method_Pattern getResult() {
        return product;
    }
}

class ConcreteBuilder extends Builder {
    @Override
    public void buildPartA() {
        product.setPartA("Parte A");
    }

    @Override
    public void buildPartB() {
        product.setPartB("Parte B");
    }
}

class Director {
    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public void construct() {
        builder.buildPartA();
        builder.buildPartB();
    }
}
