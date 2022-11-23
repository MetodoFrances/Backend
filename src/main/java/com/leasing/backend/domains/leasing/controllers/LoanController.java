package com.leasing.backend.domains.leasing.controllers;

import com.leasing.backend.domains.leasing.domain.entities.Loan;
import com.leasing.backend.domains.leasing.domain.service.LoanService;
import com.leasing.backend.domains.leasing.mapping.LoanMapper;
import com.leasing.backend.domains.leasing.resources.LoanResource;
import com.leasing.backend.domains.leasing.resources.SaveLoanResource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/loans")
public class LoanController {
    @Autowired
    private final LoanService loanService;

    private final LoanMapper mapper;

    public LoanController(LoanService loanService, LoanMapper mapper) {
        this.loanService = loanService;
        this.mapper = mapper;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/user_id={id}")
    public List<Loan> getByUserId(@PathVariable(value = "id") Long id) {
        return loanService.getAllByUserId(id);
    }

    @CrossOrigin(origins = "*")
    @PostMapping
    public ResponseEntity<LoanResource> create(@RequestBody SaveLoanResource resource) {
        return new ResponseEntity<LoanResource>(
                this.mapper.toResource(
                        this.loanService.create(
                                this.mapper.toModel(resource)
                        )
                ),
                HttpStatus.CREATED
        );
    }
}
