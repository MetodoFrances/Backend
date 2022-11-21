package com.leasing.backend.domains.leasing.controllers;

import com.leasing.backend.domains.leasing.domain.entities.Settings;
import com.leasing.backend.domains.leasing.domain.service.SettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = {"http://localhost:4200", "http://127.0.0.1:5173"})
@RestController
@RequestMapping("/settings")
public class SettingsController {

    @Autowired
    private SettingsService settingsService;


    @GetMapping
    public ResponseEntity<List<Settings>> getAllSettings(){
        List<Settings> settings = settingsService.findSettings();
        return new ResponseEntity<List<Settings>>(settings,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Settings> addSettings(@RequestBody Settings settings) {
        Settings newSettings = settingsService.saveSettings(
                new Settings(
                        settings.getLanguageName(),
                        settings.getCountry()
                )
        );

        return new ResponseEntity<Settings>(newSettings, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Settings> updateSettings(
            @PathVariable("id") Long id,
            @RequestBody Settings settings){
        Settings settingsUpdated= settingsService.findBySettingsId(id);

            settingsUpdated.setLanguageName(settings.getLanguageName());
            settingsUpdated.setCountry(settings.getCountry());

        return new ResponseEntity<Settings>(settingsService.saveSettings(settingsUpdated),
                HttpStatus.OK);
    }


}
