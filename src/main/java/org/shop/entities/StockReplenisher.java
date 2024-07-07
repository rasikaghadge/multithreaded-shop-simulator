package org.shop.entities;

public class StockReplenisher implements  Runnable {
    private String name;
    private Shop shop;

    public StockReplenisher(String name, Shop shop) {
        this.name = name;
        this.shop = shop;
    }

    @Override
    public void run() {
        while(true) {
            try {
                shop.replenishStock();
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                System.out.println("Exception in thread " + Thread.currentThread().getName());
                Thread.currentThread().interrupt();
            }
        }
    }
}
