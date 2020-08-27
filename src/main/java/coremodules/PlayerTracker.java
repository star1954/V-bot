package coremodules;

import core.Module_Interface_Event;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PlayerTracker extends Module_Interface_Event {
    public static List<User> players = new ArrayList<>();
    //get playerlist object
    private static JSONObject getPlayers() throws FileNotFoundException {//If this throws a FileNotFound, you're missing the auth token.
        FileReader FR = new FileReader("src/main/json/Users.json");
        JSONParser parser = new JSONParser();
        JSONObject obj = null;
        try {
            obj = (JSONObject)parser.parse(FR);
        } catch (ParseException e) {
            System.out.println("[FATAL]Error parsing JSON file");
            e.printStackTrace();

        } catch (IOException e) {
            System.out.println("[FATAL]Error reading json file");
            e.printStackTrace();
        }
        return obj;
    }

    public PlayerTracker(){
        JSONObject playersobj = null;
        try {
            playersobj = getPlayers();
        }catch(FileNotFoundException e){
            e.printStackTrace();
            logger.error("Could not find Users.json",e);
            return;
        }


    }

    @Override
    public void OnMessage(GuildMessageReceivedEvent event) {
        super.OnMessage(event);
        User tempuser = new User(event.getAuthor());

    }
}
