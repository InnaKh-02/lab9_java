package org.example;

import lombok.*;

@Getter
@ToString
public class DVD {
    private static int idCounter = 0;

    private final int id;
    private final String title;
    private final double pricePerDay;

    public DVD(String title, double pricePerDay) {
        this.id = ++idCounter;
        this.title = title;
        this.pricePerDay = pricePerDay;
    }
}
