package Commands.Music;

import Lavaplayer.PlayerManager;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

public class PlayCommand {
    public static void onCall(MessageReceivedEvent event) {
        JoinCommand.onCall(event);
        String[] inputStringArray = event.getMessage().getContentRaw().split(" ");
        if (inputStringArray.length == 1) {
            event.getChannel().sendMessageEmbeds(new EmbedBuilder()
                    .setDescription("The correct way to use this command is `!!play <url/name>`.")
                    .setColor(65535).build()).queue();
            return;
        }

        StringBuilder query = new StringBuilder();
        for (int i = 1; i < inputStringArray.length; i++) {
            query.append(inputStringArray[i]);
            if (i != inputStringArray.length - 1) {
                query.append(" ");
            }
        }

        String queryString = query.toString();

        if (!isUrl(queryString)) {
            queryString = "ytsearch:" + queryString;
        }
        PlayerManager.getInstance().loadAndPlay(event.getTextChannel(), queryString);
    }

    private static boolean isUrl(String url) {
        try {
            URL obj = new URL(url);
            obj.toURI();
            return true;
        } catch (MalformedURLException | URISyntaxException e) {
            return false;
        }
    }
}
