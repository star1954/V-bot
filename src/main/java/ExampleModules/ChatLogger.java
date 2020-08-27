package ExampleModules;

import coremodules.Command_Interface;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
public class ChatLogger extends Command_Interface {

    @Override
    public void OnMessage(GuildMessageReceivedEvent event) {
        super.OnMessage(event);
        System.out.println("asdf");
        logger.info(event.getAuthor()+" "+event.getChannel()+": "+event.getMessage().getContentRaw());
    }
}

