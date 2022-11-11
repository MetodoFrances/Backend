package com.leasing.backend.domains.leasing.domain.service;

import com.leasing.backend.domains.leasing.domain.entities.Loan;

import java.util.List;

public interface LoanService {
    List<Loan> getAllByUserId(Long userId);
    Loan create(Loan loan);
}
