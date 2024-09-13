package org.jarro.listener;

import lombok.extern.slf4j.Slf4j;
import net.dv8tion.jda.api.events.session.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

@Slf4j
public class ReadyListener extends ListenerAdapter {
    @Override
    public void onReady(ReadyEvent event) {
        log.info("Bot is ready! Logged in as {}", event.getJDA().getSelfUser().getName());
    }
}