package org.example;

import jakarta.persistence.*;
import lombok.*;

@Getter
@ToString
@Entity
@Table(name = "dvd")
public class DVD {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private boolean available = true;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "price_per_day", nullable = false)
    private double pricePerDay;

    public DVD() {
    }

    public DVD(String title, double pricePerDay) {
        this.title = title;
        this.pricePerDay = pricePerDay;
        this.available = true;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}