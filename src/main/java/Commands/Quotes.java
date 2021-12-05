package Commands;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class Quotes {
    public static void onCall(MessageReceivedEvent event) throws IOException {
        /*
        Should I switch to GSON or Jackson for parsing JSON?
         */
        String url = "https://api.quotable.io/random";
        String jsonString = new Scanner(new URL(url).openStream(), "UTF-8").useDelimiter("\\A").next();
        JSONObject obj = new JSONObject(jsonString);
        String quote = obj.getString("content");
        String quoteAuthor = obj.getString("author");

        event.getChannel().sendMessage(event.getAuthor().getAsMention() + " Here is your quote : \n" + "```\n" + quote + "\n\n" + "~" + quoteAuthor + "\n```").queue();
    }
}
