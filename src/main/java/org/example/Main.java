package org.example;

public class Main {
    public static void main(String[] args) {
        DVDStore store = new DVDStore();

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