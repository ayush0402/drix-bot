import Commands.*;
import Commands.Music.*;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public class CommandsListener extends ListenerAdapter {

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        String prefix = "!!";
        String input = event.getMessage().getContentRaw();

        if(input.equalsIgnoreCase(prefix + "shutdown")){
            String owner_id = "543383004349726732";
            ShutdownCommand.onCall(event,owner_id);
        }
        if(input.equalsIgnoreCase(prefix + "hello")){
            Hello.onCall(event);
        }
        if(input.equalsIgnoreCase(prefix+"help")){
            HelpCommand.onCall(event);
        }
        if(input.equalsIgnoreCase(prefix+"quote")){
            try {
                QuotesCommand.onCall(event);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(input.equalsIgnoreCase(prefix+"meme")){
            try {
                MemeCommand.onCall(event);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(input.equalsIgnoreCase(prefix+"join")){
            JoinCommand.onCall(event);
        }
        if(input.startsWith(prefix+"play")){
            PlayCommand.onCall(event);
        }
        if(input.equalsIgnoreCase(prefix+"stop")){
            StopCommand.onCall(event);
        }
        if(input.equalsIgnoreCase(prefix+"skip")){
            SkipCommand.onCall(event);
        }
        if(input.equalsIgnoreCase(prefix+"queue")){
            QueueCommand.onCall(event);
        }
        if(input.equalsIgnoreCase(prefix+"disconnect")){
            DisconnectCommand.onCall(event);
        }

    }
}
