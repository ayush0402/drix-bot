package Commands;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class Shutdown {
    public static void onCall(MessageReceivedEvent event, String owner_id) {
        if(event.getAuthor().getId().equals(owner_id)){
            event.getChannel().sendMessage("Drix is shutting down...").queue();
            event.getJDA().shutdown();
        }
        else{
            event.getChannel().sendMessage("You are not authorized to use this command.").queue();
        }
    }
}
