package Commands.Music;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.AudioChannel;
import net.dv8tion.jda.api.entities.GuildVoiceState;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.managers.AudioManager;

public class JoinCommand {
    public static void onCall(MessageReceivedEvent event) {
        GuildVoiceState gvs = event.getMember().getVoiceState();
        if (gvs.inAudioChannel()) {
            AudioChannel ac = gvs.getChannel();
            AudioManager audioManager = event.getGuild().getAudioManager();
            event.getChannel().sendMessageEmbeds(new EmbedBuilder()
                    .setDescription("Connecting to voice...")
                    .setColor(65535).build()).queue();
            audioManager.openAudioConnection(ac);
        } else {
            event.getChannel().sendMessageEmbeds(new EmbedBuilder()
                    .setDescription("You need to be in a voice channel to use this command.")
                    .setColor(65535).build()).queue();
        }
    }
}
