import Commands.*;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public class CommandsListener extends ListenerAdapter {

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        String prefix = Config.get("PREFIX");
        String input = event.getMessage().getContentRaw();

        if(input.equalsIgnoreCase(prefix + "shutdown")){
            String owner_id = Config.get("OWNER_ID");
            Shutdown.onCall(event,owner_id);
        }
        if(input.equalsIgnoreCase(prefix + "hello")){
            Hello.onCall(event);
        }
        if(input.equalsIgnoreCase(prefix+"help")){
            Help.onCall(event);
        }
        if(input.equalsIgnoreCase(prefix+"quote")){
            try {
                Quotes.onCall(event);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
