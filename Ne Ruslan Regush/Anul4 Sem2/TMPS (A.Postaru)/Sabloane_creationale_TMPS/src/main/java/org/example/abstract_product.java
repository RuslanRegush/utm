package org.example;

abstract class Product {
    public abstract void use();
}

class ConcreteProductA extends Product {
    @Override
    public void use() {
        System.out.println("Utilizând produsul A.");
    }
}

class ConcreteProductB extends Product {
    @Override
    public void use() {
        System.out.println("Utilizând produsul B.");
    }
}

abstract class Creator {
    public abstract Product factoryMethod();

    public void operation() {
        Product product = factoryMethod();
        product.use();
    }
}

class ConcreteCreatorA extends Creator {
    @Override
    public Product factoryMethod() {
        return new ConcreteProductA();
    }
}

class ConcreteCreatorB extends Creator {
    @Override
    public Product factoryMethod() {
        return new ConcreteProductB();
    }
}

