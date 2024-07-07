package org.shop.entities;

public class Customer implements Runnable {
    private String name;
    private Shop shop;

    public Customer(String name, Shop shop) {
        this.name = name;
        this.shop = shop;
    }

    @Override
    public void run() {
        while (true) {
            try {
                shop.enterShop(this);
                shop.pickItems(this);
                shop.enterQueue(this);
                shop.checkout(this);
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                System.out.println("Exception in thread " + Thread.currentThread().getName());
                Thread.currentThread().interrupt();
            }
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
