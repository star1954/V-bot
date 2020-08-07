package core;

import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.events.DisconnectEvent;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.events.guild.GuildReadyEvent;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.ServiceLoader;
//this is where things get complicated
public class Main extends ListenerAdapter {
    //Config
    private final char commandID = '!';


    //important stuff
    public static final JDABuilder builder = Bot.init();
    //allows extendability by adding services. For future additions and to keep code clean
    private static final ServiceLoader<Module_Event_Interface> eventModules = ServiceLoader.load(Module_Event_Interface.class);


    public static void main(String[] args){
        //Ping ping = new Ping();
        //ServiceLoader<Module_Event_Interface> eventModules = ServiceLoader.load(Module_Event_Interface.class);

    }

    public Main(){

    }

//various events
    @Override
    public void onReady(ReadyEvent event) {
        super.onReady(event);
        System.out.println("API Ready");
        eventModules.forEach(a -> {
            a.OnReady(event);
        });
    }

    //guild = discord server
    @Override
    public void onGuildReady(@NotNull GuildReadyEvent event) {
        super.onGuildReady(event);
        eventModules.forEach(a -> {
            a.OnGuildReady(event);
        });
    }

    //when the bot dies
    @Override
    public void onDisconnect(@NotNull DisconnectEvent event) {
        super.onDisconnect(event);
        System.out.println("Disconnected");
    }

    //when recieving a message in a server
    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String message = event.getMessage().getContentDisplay();
        //System.out.println(eventModules.findFirst());
        if (message.charAt(0) == commandID) {
            eventModules.forEach(a -> {
                a.OnCommand(event);
            });
        }
        eventModules.forEach(a -> {
            a.OnMessage(event);
        });
    }
}
