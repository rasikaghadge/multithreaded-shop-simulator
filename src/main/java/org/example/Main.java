package org.example;

import org.shop.entities.Cashier;
import org.shop.entities.Customer;
import org.shop.entities.Shop;
import org.shop.entities.StockReplenisher;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Shop shop = new Shop();

        Thread customer1 = new Thread(new Customer("Customer 1", shop));
        Thread customer2 = new Thread(new Customer("Customer 2", shop));
        customer1.start();
        customer2.start();

        Thread cashier1 = new Thread(new Cashier("Cashier 1", shop));
        cashier1.start();

        Thread replenisher1 = new Thread(new StockReplenisher("Replenisher 1", shop));
        replenisher1.start();
    }
}
