package org.jarro.config;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.Properties;

@Getter
@Setter
@Slf4j
public class BotConfig {

    private final String token;

    public BotConfig() {
        Properties properties = new Properties();
        try {
            properties.load(getClass().getClassLoader().getResourceAsStream("application.properties"));
            token = properties.getProperty("discord.token");
        } catch (IOException e) {
            log.error("Failed to load application.properties", e);
            throw new RuntimeException("Failed to load configuration", e);
        }
    }
}
