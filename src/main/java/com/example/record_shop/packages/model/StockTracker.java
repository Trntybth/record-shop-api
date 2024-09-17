package com.example.record_shop.packages.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

@Entity
@Table(name = "stock-tracker")
public class StockTracker {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private boolean inStock;
    private int numberInStock;

    @OneToOne
    @JoinColumn(name = "record_id", unique = true)
    private Album record;
}
