package com.leasing.backend.domains.leasing.domain.service;

import com.leasing.backend.domains.leasing.domain.entities.Currency;

import java.util.List;

//USAN USER POR LOAN, NO SE QUE USAR ACA
public interface CurrencyService {
    List<Currency> getAllByUserId(Long userId);
    Currency create(Currency currency);
}
