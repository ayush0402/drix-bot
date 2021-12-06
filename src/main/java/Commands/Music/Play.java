package Commands.Music;

import Lavaplayer.PlayerManager;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class Play {
    public static void onCall(MessageReceivedEvent event) {
        Join.onCall(event);
        PlayerManager.getInstance().loadAndPlay(event.getTextChannel(),"https://www.youtube.com/watch?v=jkaMiaRLgvY");
    }
}
