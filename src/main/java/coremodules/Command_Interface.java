package coremodules;

import core.Module_Event_Interface;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

public class Command_Interface extends Module_Event_Interface {
    protected String[] args;

    /**
     * Splits substring at space, and cuts out the command identifier
     * @param event message received event
     * @see Module_Event_Interface
     */
    @Override
    public void OnCommand(GuildMessageReceivedEvent event) {
        super.OnCommand(event);

        String message = event.getMessage().getContentRaw().substring(1);
        args = message.split(" ");
        //System.out.println(args.length);
    }
}
