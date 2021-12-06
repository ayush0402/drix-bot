import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import javax.security.auth.login.LoginException;

public class Drix {
    public static void main(String[] args) throws LoginException {
        JDA jda = JDABuilder.createDefault(System.getenv().get("TOKEN")).build();

        jda.addEventListener(new CommandsListener());
    }
}
