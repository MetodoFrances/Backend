package com.leasing.backend.domains.leasing.services;

import com.leasing.backend.domains.leasing.domain.entities.Loan;
import com.leasing.backend.domains.leasing.domain.persistance.LoanRepository;
import com.leasing.backend.domains.leasing.domain.service.LoanService;
import com.leasing.backend.shared.exception.ResourceValidationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Slf4j
@Service
public class LoanServiceImpl implements LoanService {
    private static final String ENTITY = "loans";

    @Autowired
    private final LoanRepository loanRepository;

    private final Validator validator;

    public LoanServiceImpl(LoanRepository loanRepository, Validator validator) {
        this.loanRepository = loanRepository;
        this.validator = validator;
    }

    @Override
    public List<Loan> getAllByUserId(Long userId) {
        return this.loanRepository.findAll().stream().filter((Loan loan) -> loan.getUser().getId().equals(userId)).toList();
    }

    @Override
    public Loan create(Loan loan) {
        Set<ConstraintViolation<Loan>> violations = this.validator.validate(loan);
        if(!violations.isEmpty())
            throw new ResourceValidationException(ENTITY,violations);
        return loanRepository.save(loan);
    }
}
