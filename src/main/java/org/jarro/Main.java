package org.jarro;

import lombok.extern.slf4j.Slf4j;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.jarro.config.BotConfig;
import org.jarro.listener.MessageListener;
import org.jarro.listener.ReadyListener;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
@Slf4j
public class Main {

    public static void main(String[] args) {
        // Load configuration
        BotConfig botConfig = new BotConfig();
        final String token = botConfig.getToken();

        try {
            JDABuilder.createDefault(token)
                    .enableIntents(GatewayIntent.GUILD_MESSAGES, GatewayIntent.MESSAGE_CONTENT)
                    .setActivity(Activity.playing("MineCraft"))
                    .addEventListeners(new ReadyListener(), new MessageListener())
                    .build();
        } catch (Exception e) {
            log.error("Failed to initialize JDA", e);
        }
    }
}