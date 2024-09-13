package org.jarro.listener;


import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jarro.command.Command;
import org.jarro.command.PingCommand;

import java.util.HashMap;
import java.util.Map;

public class MessageListener extends ListenerAdapter {

    private final Map<String, Command> commands = new HashMap<>();

    public MessageListener() {
        // Register commands
        commands.put("!ping", new PingCommand());
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getAuthor().isBot()) {
            return; // Ignore messages from bots
        }

        String content = event.getMessage().getContentRaw().toLowerCase();

        Command command = commands.get(content);
        if (command != null) {
            command.execute(event);
        }
    }
}