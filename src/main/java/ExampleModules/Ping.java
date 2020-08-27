package ExampleModules;

import coremodules.Command_Interface;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

public class Ping extends Command_Interface {
    @Override
    public void OnCommand(GuildMessageReceivedEvent event) {
        super.OnCommand(event);
        //use a switch statement for each command
        switch (args[0]){
            case "ping":
                event.getChannel().sendMessage("Pong!").queue();
                //System.out.println("Ponging");
                break;
        }
    }

}
