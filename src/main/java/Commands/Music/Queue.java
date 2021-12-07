package Commands.Music;

import Lavaplayer.GuildMusicManager;
import Lavaplayer.PlayerManager;
import com.sedmelluq.discord.lavaplayer.track.AudioTrack;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class Queue {
    public static void onCall(MessageReceivedEvent event) {
        final GuildMusicManager musicManager = PlayerManager.getInstance().getMusicManager(event.getGuild());
        EmbedBuilder emb = new EmbedBuilder();
        emb.setTitle("Queue has "+musicManager.scheduler.queue.size()+" tracks :");
        for (AudioTrack audioTrack : musicManager.scheduler.queue) {
            StringBuilder line = new StringBuilder();
            line.append(audioTrack.getInfo().title)
                    .append(" ")
                    .append(" by ")
                    .append(audioTrack.getInfo().author);
            emb.appendDescription(line.toString()+"\n");
        }
        event.getChannel().sendMessageEmbeds(emb.build()).queue();
    }
}
