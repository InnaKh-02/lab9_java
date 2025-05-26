package org.example;

import jakarta.persistence.*;
import lombok.*;

@Getter
@ToString
@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    public Customer() {
    }

    public Customer(String name) {
        this.name = name;
    }
}