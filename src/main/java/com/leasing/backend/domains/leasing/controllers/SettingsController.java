package com.leasing.backend.domains.leasing.controllers;

import com.leasing.backend.domains.leasing.domain.entities.Settings;
import com.leasing.backend.domains.leasing.domain.service.SettingsService;
import com.leasing.backend.domains.leasing.mapping.SettingsMapper;
import com.leasing.backend.domains.leasing.resources.LoanResource;
import com.leasing.backend.domains.leasing.resources.SaveSettingsResource;
import com.leasing.backend.domains.leasing.resources.SettingsResource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController
@RequestMapping("/settings")
public class SettingsController {

    @Autowired
    private SettingsService settingsService;

    private SettingsMapper mapper;

    public SettingsController(SettingsService settingsService, SettingsMapper mapper) {
        this.settingsService = settingsService;
        this.mapper = mapper;
    }

    @CrossOrigin(origins = "*")
    @GetMapping
    public ResponseEntity<List<Settings>> getAllSettings(){
        List<Settings> settings = settingsService.findSettings();
        return new ResponseEntity<List<Settings>>(settings,HttpStatus.OK);
    }

    @CrossOrigin(origins = "*")
    @PostMapping
    public ResponseEntity<SettingsResource> addSettings(@RequestBody SaveSettingsResource resource) {
        return new ResponseEntity<SettingsResource>(
                this.mapper.toResource(
                        this.settingsService.saveSettings(
                                this.mapper.toModel(resource)
                        )
                ),
                HttpStatus.CREATED
        );
    }

    @CrossOrigin(origins = "*")
    @PutMapping("/{id}")
    public SettingsResource updateSettings(
            @PathVariable("id") Long id,
            @RequestBody SaveSettingsResource settings){
        return mapper.toResource(
                settingsService.updateSettings(id,mapper.toModel(settings))
        );
    }


}
