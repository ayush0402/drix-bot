package Commands.Music;

import net.dv8tion.jda.api.entities.AudioChannel;
import net.dv8tion.jda.api.entities.GuildVoiceState;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.managers.AudioManager;

public class Join {
    public static void onCall(MessageReceivedEvent event) {
        GuildVoiceState gvs = event.getMember().getVoiceState();
        if(gvs.inAudioChannel()){
            AudioChannel ac = gvs.getChannel();
            AudioManager audioManager = event.getGuild().getAudioManager();
            event.getChannel().sendMessage("Connecting to voice...").queue();
            audioManager.openAudioConnection(ac);
        }
        else{
            event.getChannel().sendMessage("You need to be in a voice channel to use this command.").queue();
        }
    }
}
