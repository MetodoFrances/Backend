package com.leasing.backend.domains.leasing.services;

import com.leasing.backend.domains.leasing.domain.entities.Settings;
import com.leasing.backend.domains.leasing.domain.persistence.SettingsRepository;
import com.leasing.backend.domains.leasing.domain.service.SettingsService;
import com.leasing.backend.shared.exception.ResourceNotFoundException;
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
public class SettingsServiceImpl implements SettingsService {
    private static final String ENTITY = "settings";

    @Autowired
    private final SettingsRepository settingsRepository;

    private final Validator validator;

    public SettingsServiceImpl(SettingsRepository settingsRepository, Validator validator) {
        this.settingsRepository = settingsRepository;
        this.validator = validator;
    }

    @Override
    public List<Settings> findSettings() {
        return this.settingsRepository.findSettings();
    }

    @Override
    public Settings findBySettingsId(Long id) {
        return this.settingsRepository.getById(id);
    }

    @Override
    public Settings saveSettings(Settings settings) {
        Set<ConstraintViolation<Settings>> violations = this.validator.validate(settings);
        if(!violations.isEmpty())
            throw new ResourceValidationException(ENTITY,violations);
        return this.settingsRepository.save(settings);
    }

    @Override
    public Settings updateSettings(Long id, Settings settings) {
        Set<ConstraintViolation<Settings>> violations = validator.validate(settings);

        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return settingsRepository.findById(id).map(
                reservation -> settingsRepository.save(
                        reservation.withCountry(settings.getCountry()).withLanguageName(settings.getLanguageName())))
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, id));
    }
}
