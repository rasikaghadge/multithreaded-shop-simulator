package org.shop.entities;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.LinkedBlockingDeque;

public class Shop {
    private final BlockingDeque<Customer> queue =  new LinkedBlockingDeque<>();
    private final ConcurrentMap<String, Integer> inventory = new ConcurrentHashMap<>();

    public Shop() {
        // Initialize inventory with some items
        inventory.put("Item1", 10);
        inventory.put("Item2", 15);
        inventory.put("Item3", 20);
    }

    public void enterShop(Customer customer) {
        System.out.println(customer.getName() + " entered the shop.");
    }

    public void pickItems(Customer customer) {
        System.out.println(customer.getName() + " is picking items.");
    }

    public void enterQueue(Customer customer) throws InterruptedException {
        queue.put(customer);
        System.out.println(customer.getName() + " is waiting in the queue.");
    }

    public void checkout(Customer customer) {
        System.out.println(customer.getName() + " has checked out.");
    }

    public void processNextCustomer(Cashier cashier) throws InterruptedException {
        Customer customer = queue.take();
        System.out.println(cashier.getName() + " is processing " + customer.getName());
    }

    public void replenishStock() {
        System.out.println("Stock Replenisher is replenishing stock.");
        inventory.computeIfPresent("Item1", (k, v) -> v + 5);
        inventory.computeIfPresent("Item2", (k, v) -> v + 5);
        inventory.computeIfPresent("Item3", (k, v) -> v + 5);
        System.out.println("Stock has been replenished.");
    }
}
