package Commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class QuotesCommand {
    public static void onCall(MessageReceivedEvent event) throws IOException {
        /*
        Should I switch to GSON or Jackson for parsing JSON?
         */
        String url = "https://api.quotable.io/random";
        String jsonString = new Scanner(new URL(url).openStream(), "UTF-8").useDelimiter("\\A").next();
        JSONObject obj = new JSONObject(jsonString);
        String quote = obj.getString("content");
        String quoteAuthor = obj.getString("author");

        EmbedBuilder emb = new EmbedBuilder();
        emb.setDescription(quote).setFooter(quoteAuthor).setTitle(event.getAuthor().getName()+", here is a quote for you : ");
        event.getChannel().sendMessageEmbeds(emb.build()).queue();
    }
}
