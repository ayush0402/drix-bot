package Commands.Music;

import Lavaplayer.GuildMusicManager;
import Lavaplayer.PlayerManager;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class Stop {
    public static void onCall(MessageReceivedEvent event) {
        final GuildMusicManager musicManager = PlayerManager.getInstance().getMusicManager(event.getGuild());
        musicManager.scheduler.player.stopTrack();
        musicManager.scheduler.queue.clear();

        event.getChannel().sendMessage("The player has been stopped and queue has been cleared.").queue();
    }
}
