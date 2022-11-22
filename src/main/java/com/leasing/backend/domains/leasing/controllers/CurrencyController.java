package com.leasing.backend.domains.leasing.controllers;

import com.leasing.backend.domains.leasing.domain.entities.Currency;
import com.leasing.backend.domains.leasing.domain.service.CurrencyService;
import com.leasing.backend.domains.leasing.mapping.CurrencyMapper;
import com.leasing.backend.domains.leasing.resources.CurrencyResource;
import com.leasing.backend.domains.leasing.resources.SaveCurrencyResource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/Currency")
public class CurrencyController {
    @Autowired
    private final CurrencyService CurrencyService;

    private final CurrencyMapper mapper;

    public CurrencyController(CurrencyService CurrencyService, CurrencyMapper mapper) {
        this.CurrencyService = CurrencyService;
        this.mapper = mapper;
    }
    @GetMapping("/currency_id={id}")
    public List<Currency> getByUserId(@PathVariable(value = "id") Long id) {
        return CurrencyService.getAllByUserId(id);
    }
    @PostMapping
    public ResponseEntity<CurrencyResource> create(@RequestBody SaveCurrencyResource resource) {
        return new ResponseEntity<CurrencyResource>(
                this.mapper.toResource(
                        this.CurrencyService.create(
                                this.mapper.toModel(resource)
                        )
                ),
                HttpStatus.CREATED
        );
    }
}
