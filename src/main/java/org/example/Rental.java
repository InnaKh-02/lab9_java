package org.example;

import lombok.Getter;

import java.time.LocalDate;
@Getter
public class Rental {

    private final DVD dvd;
    private final Customer customer;
    private final LocalDate rentDate;
    private final int days;

    public Rental(DVD dvd, Customer customer, int days) {
        this.dvd = dvd;
        this.customer = customer;
        this.days = days;
        this.rentDate = LocalDate.now();
    }
    public LocalDate getDueDate() { return rentDate.plusDays(days); }

    public double getTotalPrice() {
        return days * dvd.getPricePerDay();
    }

    @Override
    public String toString() {
        return dvd + " rented by " + customer +
                " | Return by: " + getDueDate() +
                " | Total: ₴" + getTotalPrice();
    }
}
