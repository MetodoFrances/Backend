package com.leasing.backend.domains.leasing.mapping;

import com.leasing.backend.domains.leasing.domain.entities.Loan;
import com.leasing.backend.domains.leasing.resources.LoanResource;
import com.leasing.backend.domains.leasing.resources.SaveLoanResource;
import com.leasing.backend.shared.mapping.EnhancedModelMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

@Slf4j
public class LoanMapper implements Serializable {
    @Autowired
    EnhancedModelMapper mapper;

    public LoanResource toResource(Loan model) {
        return mapper.map(model,LoanResource.class);
    }

    public Page<LoanResource> modelListPage(List<Loan> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList,LoanResource.class), pageable, modelList.size());
    }

    public Loan toModel(SaveLoanResource resource) {
        mapper.getConfiguration().setAmbiguityIgnored(true);
        return mapper.map(resource, Loan.class);
    }
}
