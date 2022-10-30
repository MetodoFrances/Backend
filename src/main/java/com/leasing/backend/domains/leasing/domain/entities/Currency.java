package com.leasing.backend.domains.leasing.domain.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "currencies")
@Data
@NoArgsConstructor
public class Currency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long currencyId;
    private String name;
    private Float exchangeRate;

    public Currency(String name, Float exchangeRate) {
        this.name = name;
        this.exchangeRate = exchangeRate;
    }
}
