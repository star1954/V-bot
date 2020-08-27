package core;

import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.events.guild.GuildReadyEvent;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

public class Module_Interface_Event extends Module_Interface{


    /**
     *              Is called when the bot receives any message, including a command. Use only when necessary, as this will fire every message
     * @param event message received event
     */
    public void OnMessage(GuildMessageReceivedEvent event){}

    /**
     *              Is called when the bot receives a command. Default identifier for a command is ! followed by a message
     * @param event message received event
     */
    public void OnCommand(GuildMessageReceivedEvent event){}

    /**
     *              Is called when the bot is successfully initialized\n
     * @param event message received event
     */
    public void OnReady(ReadyEvent event){}
    public void OnGuildReady(GuildReadyEvent event){}
}
