package Commands.Music;

import Lavaplayer.GuildMusicManager;
import Lavaplayer.PlayerManager;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class StopCommand {
    public static void onCall(MessageReceivedEvent event) {
        final GuildMusicManager musicManager = PlayerManager.getInstance().getMusicManager(event.getGuild());
        musicManager.scheduler.player.stopTrack();
        musicManager.scheduler.queue.clear();

        event.getChannel().sendMessageEmbeds(new EmbedBuilder()
                .setDescription("The player has been stopped and queue has been cleared.")
                .setColor(65535).build()).queue();
    }
}
