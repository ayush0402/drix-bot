package Commands;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class Hello {
    public static void onCall(MessageReceivedEvent event) {
        event.getChannel().sendMessage("Hello User! from local bot").queue();
    }
}
