package com.leasing.backend.domains.leasing.mapping;

import com.leasing.backend.domains.leasing.domain.entities.Loan;
import com.leasing.backend.domains.leasing.domain.entities.Settings;
import com.leasing.backend.domains.leasing.resources.LoanResource;
import com.leasing.backend.domains.leasing.resources.SaveLoanResource;
import com.leasing.backend.domains.leasing.resources.SaveSettingsResource;
import com.leasing.backend.domains.leasing.resources.SettingsResource;
import com.leasing.backend.shared.mapping.EnhancedModelMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

@Slf4j
public class SettingsMapper implements Serializable {
    @Autowired
    EnhancedModelMapper mapper;

    public SettingsResource toResource(Settings model) {
        return mapper.map(model,SettingsResource.class);
    }

    public Page<SettingsResource> modelListPage(List<Settings> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList,SettingsResource.class), pageable, modelList.size());
    }

    public Settings toModel(SaveSettingsResource resource) {
        mapper.getConfiguration().setAmbiguityIgnored(true);
        return mapper.map(resource, Settings.class);
    }
}
