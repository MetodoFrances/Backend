package com.leasing.backend.domains.leasing.domain.service;

import com.leasing.backend.domains.leasing.domain.entities.Settings;
import com.leasing.backend.domains.leasing.domain.persistence.SettingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SettingsService{

    @Autowired
    private final SettingsRepository settingsRepository;

    public SettingsService(SettingsRepository settingsRepository) {
        this.settingsRepository = settingsRepository;
    }

    public List<Settings> findSettings(){ return settingsRepository.findSettings();}

    public Settings findBySettingsId(Long id){
        return settingsRepository.findBySettingsId(id);}

    public Settings saveSettings(Settings settings){
        settingsRepository.save(settings);

        return settings;
    }

}
