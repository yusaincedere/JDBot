package org.jarro.command;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.util.Random;

public class PingCommand implements Command{

    private final Random random = new Random();
    private final String[] pingMessages = {
            "Time for a true display of skill!",
            "I never miss.",
            "It’s all skill.",
            "You belong in a museum!",
            "Let’s do this!",
            "No time to waste!"
    };

    @Override
    public void execute(MessageReceivedEvent event) {
        long time = System.currentTimeMillis();
        String randomMessage = pingMessages[random.nextInt(pingMessages.length)];
        event.getChannel().sendMessage(randomMessage).queue(response -> {
            long pingTime = System.currentTimeMillis() - time;
            String message = randomMessage +
                    " Ping: " +
                    pingTime +
                    " ms";
            response.editMessage(message).queue();
        });
    }

    @Override
    public String getCommandName() {
        return "Ping";
    }
}
