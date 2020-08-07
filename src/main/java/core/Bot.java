package core;

import net.dv8tion.jda.api.JDABuilder;

import javax.security.auth.login.LoginException;

public class Bot {
    public static JDABuilder builder = null;
    public static JDABuilder init(){
        //initialize stuff
        builder = BotInit.createJDA();
        builder.addEventListeners(new Main()); //set up Main as the event handler
        //login
        try {
            BotInit.BotLogin(builder);
        } catch (LoginException e) {
            e.printStackTrace();
            System.out.println("Core.Bot Failed to login. Auth code is invalid/Cannot connect to Discord");
        }
        return builder;
    }
}
