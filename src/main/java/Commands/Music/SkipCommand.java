package Commands.Music;

import Lavaplayer.GuildMusicManager;
import Lavaplayer.PlayerManager;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class SkipCommand {
    public static void onCall(MessageReceivedEvent event) {
        final GuildMusicManager musicManager = PlayerManager.getInstance().getMusicManager(event.getGuild());
        musicManager.scheduler.nextTrack();
        event.getChannel().sendMessageEmbeds(new EmbedBuilder().setDescription("Skipped...").setColor(65535).build()).queue();
    }
}
