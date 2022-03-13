package Commands.Music;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.AudioChannel;
import net.dv8tion.jda.api.entities.GuildVoiceState;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.managers.AudioManager;

import java.awt.*;

public class DisconnectCommand {
    public static void onCall(MessageReceivedEvent event) {
        GuildVoiceState gvs = event.getMember().getVoiceState();
        AudioChannel ac = gvs.getChannel();
        AudioManager audioManager = event.getGuild().getAudioManager();
        if (audioManager.isConnected()) {
            event.getChannel().sendMessageEmbeds(new EmbedBuilder().setDescription("Disconnecting from voice channel...").setColor(65535).build()).queue();
            audioManager.closeAudioConnection();
        } else {
            event.getChannel().sendMessageEmbeds(new EmbedBuilder()
                    .setDescription("The bot is not connected to any voice channel.").setColor(65535).build()).queue();
        }
    }
}
