package org.example;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Entity
@Table(name = "rental")
public class Rental {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "dvd_id", nullable = false)
    private DVD dvd;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @Column(name = "rent_date", nullable = false)
    private LocalDate rentDate;

    @Column(name = "days", nullable = false)
    private int days;

    public Rental() {
    }

    public Rental(DVD dvd, Customer customer, int days) {
        this.dvd = dvd;
        this.customer = customer;
        this.days = days;
        this.rentDate = LocalDate.now();
    }

    public LocalDate getDueDate() {
        return rentDate.plusDays(days);
    }

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