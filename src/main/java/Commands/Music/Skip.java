package Commands.Music;

import Lavaplayer.GuildMusicManager;
import Lavaplayer.PlayerManager;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class Skip {
    public static void onCall(MessageReceivedEvent event) {
        final GuildMusicManager musicManager = PlayerManager.getInstance().getMusicManager(event.getGuild());
        musicManager.scheduler.nextTrack();
        event.getChannel().sendMessage("Skipped...").queue();
    }
}
