package Commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class MemeCommand {
    public static void onCall(MessageReceivedEvent event) throws IOException {
        String apiurl = "https://meme-api.herokuapp.com/gimme";
        String jsonString = new Scanner(new URL(apiurl).openStream(), "UTF-8").useDelimiter("\\A").next();
        JSONObject obj = new JSONObject(jsonString);
        String imageUrl = obj.getString("url");
        String postTitle = obj.getString("title");
        String postLink = obj.getString("postLink");

        EmbedBuilder emb = new EmbedBuilder();
        emb.setTitle(postTitle,postLink).setImage(imageUrl);
        event.getChannel().sendMessageEmbeds(emb.build()).queue();
    }
}
