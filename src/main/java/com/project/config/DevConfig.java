package com.project.config;

import com.project.services.DBService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class DevConfig {

    @Autowired
    private DBService dbservice;

    @PostConstruct
    public void initDB(){
        this.dbservice.initiDB();
    }
}
