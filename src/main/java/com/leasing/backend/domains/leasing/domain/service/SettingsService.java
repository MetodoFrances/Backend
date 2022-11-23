package com.leasing.backend.domains.leasing.domain.service;

import com.leasing.backend.domains.leasing.domain.entities.Settings;
import com.leasing.backend.domains.leasing.domain.persistence.SettingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public interface SettingsService{
    List<Settings> findSettings();
    Settings findBySettingsId(Long id);
    Settings saveSettings(Settings settings);
}
