package com.leasing.backend.domains.leasing.domain.persistence;

import com.leasing.backend.domains.leasing.domain.entities.Settings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SettingsRepository extends JpaRepository<Settings, Long> {

    @Query("SELECT s FROM Settings s")
    List<Settings> findSettings();

    Settings findBySettingsId(Long id);


}
