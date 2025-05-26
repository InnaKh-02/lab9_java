package org.example;

import org.example.repository.CustomerRepository;
import org.example.repository.DVDRepository;
import org.example.repository.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DVDStore {
    private final DVDRepository dvdRepository;
    private final CustomerRepository customerRepository;
    private final RentalRepository rentalRepository;

    @Autowired
    public DVDStore(DVDRepository dvdRepository, CustomerRepository customerRepository, RentalRepository rentalRepository) {
        this.dvdRepository = dvdRepository;
        this.customerRepository = customerRepository;
        this.rentalRepository = rentalRepository;
    }

    public void addDVD(String title, double pricePerDay, int quantity) {
        for (int i = 0; i < quantity; i++) {
            DVD dvd = new DVD(title, pricePerDay);
            dvdRepository.save(dvd);
        }
    }

    public void rentDVD(int dvdId, Customer customer, int days) {
        DVD dvd = dvdRepository.findById(dvdId).orElse(null);
        if (dvd == null || !dvd.isAvailable()) {
            System.out.println("DVD #" + dvdId + " is not available.");
            return;
        }
        customer = customerRepository.save(customer); // Save or update
        Rental rental = new Rental(dvd, customer, days);
        rentalRepository.save(rental);

        dvd.setAvailable(false);
        dvdRepository.save(dvd);

        System.out.println("Rented: " + rental);
    }

    public void returnDVD(int dvdId) {
        Rental rental = rentalRepository.findAll().stream()
                .filter(r -> r.getDvd().getId() == dvdId)
                .findFirst()
                .orElse(null);
        if (rental != null) {
            DVD dvd = rental.getDvd();
            dvd.setAvailable(true);
            dvdRepository.save(dvd);
            rentalRepository.delete(rental);
            System.out.println("Returned: " + dvd);
        } else {
            System.out.println("No rental found for DVD #" + dvdId);
        }
    }

    public void showAvailableDVDs() {
        System.out.println("Available DVDs:");
        List<DVD> dvds = dvdRepository.findByAvailableTrue();
        dvds.forEach(System.out::println);
    }

    public void showRentedDVDs() {
        System.out.println("Rented DVDs:");
        List<Rental> rentals = rentalRepository.findAll();
        rentals.forEach(System.out::println);
    }
}