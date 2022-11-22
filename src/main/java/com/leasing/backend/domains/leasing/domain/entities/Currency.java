package com.leasing.backend.domains.leasing.domain.entities;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "currency")
@Data
@NoArgsConstructor
@Getter
@Setter
public class Currency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long currencyId;

    @Column(name = "name")
    private String name;

    @Column(name = "exchange_rate")
    private Float exchangeRate;

    public Currency(String name, Float exchangeRate) {
        this.name = name;
        this.exchangeRate = exchangeRate;
    }
}
