package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DVDStore {
    private final List<DVD> inventory = new ArrayList<>();
    private final Map<Integer, DVD> available = new HashMap<>();
    private final List<Rental> rentals = new ArrayList<>();

    public void addDVD(String title, double pricePerDay, int quantity) {
        for (int i = 0; i < quantity; i++) {
            DVD dvd = new DVD(title, pricePerDay);
            inventory.add(dvd);
            available.put(dvd.getId(), dvd);
        }
    }

    public void rentDVD(int dvdId, Customer customer, int days) {
        if (!available.containsKey(dvdId)) {
            System.out.println("DVD #" + dvdId + " is not available.");
            return;
        }
        DVD dvd = available.remove(dvdId);
        Rental rental = new Rental(dvd, customer, days);
        rentals.add(rental);
        System.out.println("Rented: " + rental);
    }

    public void returnDVD(int dvdId) {
        Rental rentalToReturn = null;
        for (Rental rental : rentals) {
            if (rental.getDvd().getId() == dvdId) {
                rentalToReturn = rental;
                break;
            }
        }

        if (rentalToReturn != null) {
            rentals.remove(rentalToReturn);
            available.put(rentalToReturn.getDvd().getId(), rentalToReturn.getDvd());
            System.out.println("Returned: " + rentalToReturn.getDvd());
        } else {
            System.out.println("No rental found for DVD #" + dvdId);
        }
    }

    public void showAvailableDVDs() {
        System.out.println("Available DVDs:");
        for (DVD dvd : available.values()) {
            System.out.println(dvd);
        }
    }

    public void showRentedDVDs() {
        System.out.println("Rented DVDs:");
        for (Rental rental : rentals) {
            System.out.println(rental);
        }
    }
}
