package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Main.class, args);
        DVDStore store = context.getBean(DVDStore.class);

        store.addDVD("The Matrix", 20.0, 2);
        store.addDVD("Inception", 25.0, 1);
        store.addDVD("Titanic", 15.0, 3);

        Customer alice = new Customer("Alice");
        Customer bob = new Customer("Bob");

        store.showAvailableDVDs();

        store.rentDVD(1, alice, 3);
        store.rentDVD(2, bob, 5);

        System.out.println();
        store.showAvailableDVDs();
        store.showRentedDVDs();

        System.out.println();
        store.returnDVD(1);
        store.showAvailableDVDs();
        store.showRentedDVDs();
    }
}