package modules;

import coremodules.Command_Interface;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

public class VaultanTracker extends Command_Interface {
    @Override
    public void OnCommand(GuildMessageReceivedEvent event) {
        super.OnCommand(event);
        if(args[0] == "!record"){

        }
    }
}
