package com.leasing.backend.domains.leasing.domain.persistance;

import com.leasing.backend.domains.leasing.domain.entities.Loan;
import com.leasing.backend.domains.leasing.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanRepository extends JpaRepository<Loan,Long> {
    @Override
    List<Loan> findAll();
}
