package ExampleModules;

import coremodules.Command_Interface;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
public class VaultanTracker extends Command_Interface {
    @Override
    public void OnCommand(GuildMessageReceivedEvent event) {
        super.OnCommand(event);
        switch (args[0]){
            case "standGive":

                break;
        }
    }

    @Override
    public void OnMessage(GuildMessageReceivedEvent event) {
        super.OnMessage(event);
        logger.info(event.getAuthor()+" "+event.getChannel()+": "+event.getMessage().getContentRaw());
    }
}

