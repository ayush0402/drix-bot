package Commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class ShutdownCommand {
    public static void onCall(MessageReceivedEvent event, String owner_id) {
        if (event.getAuthor().getId().equals(owner_id)) {
            event.getChannel().sendMessageEmbeds(new EmbedBuilder()
                    .setDescription("Drix is shutting down...").setColor(65535).build()).queue();
            event.getJDA().shutdown();
        } else {
            event.getChannel().sendMessageEmbeds(new EmbedBuilder()
                    .setDescription("You are not authorized to use this command.")
                    .setColor(65535).build()).queue();
        }
    }
}
