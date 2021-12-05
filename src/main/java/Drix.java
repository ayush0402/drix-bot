import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import javax.security.auth.login.LoginException;

public class Drix {
    public static void main(String[] args) throws LoginException {
        JDA jda = JDABuilder.createDefault(Config.get("TOKEN")).build();

        jda.addEventListener(new DemoListener());
    }
}

class DemoListener extends ListenerAdapter{
    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        if(event.getMessage().getContentRaw().equalsIgnoreCase("hellobot")){
            event.getChannel().sendMessage("HelloUser!").queue();
        }
    }
}
