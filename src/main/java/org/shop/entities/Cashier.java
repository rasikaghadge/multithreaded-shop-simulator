package org.shop.entities;

public class Cashier implements  Runnable {
    private String name;
    private Shop shop;

    public Cashier(String name, Shop shop) {
        this.name = name;
        this.shop = shop;
    }

    @Override
    public void run() {
        while (true) {
            try {
                shop.processNextCustomer(this);
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
