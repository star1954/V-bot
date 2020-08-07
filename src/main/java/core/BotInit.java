package core;

import net.dv8tion.jda.api.JDABuilder;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.security.auth.login.LoginException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BotInit {
    //pull the authentication token from the JSON file
    private static String getToken() throws FileNotFoundException {//If this throws a FileNotFound, you're missing the auth token.
        FileReader FR = new FileReader("src/main/json/Token.json");
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
        return (String) obj.get("token");
    }
    //instantiate a bot object
    public static JDABuilder createJDA(){
        String token = "blank";
        try {
            token = getToken();
        } catch (FileNotFoundException e) {
            e.printStackTrace();

        }
        assert token!="blank" : "Token is blank";
        JDABuilder builder = JDABuilder.createDefault(token);
        return builder;
    }
    //authenticate bot with discord servers
    public static void BotLogin(JDABuilder builder) throws LoginException {
        
        builder.build();
    }

}
