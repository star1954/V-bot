# V-bot

A bot for Vault(now if you don't know what that means, go shoo)



## Adding Modules
Adding a "module" through service provider is a little difficult  at first, but it's fairly simple once you get the hang of it.

### Step 1: Creating  or choosing a package
Packages are used to organize different classes into groups. In this case, you want to choose a relevant package, and if you can't find one, create one. Packages are all located under `scr/main/java`

### Step 2: Creating your action classes
Create a class inside your chosen package. You MUST extend it off of one of the Module_Interface classes, such as Module_Interface_Event, or one of the subclasses, such as Command_Interface. This allows the serviceloader to properly load your class. Use @Override to implement functionality, but make sure to call the overridden method, as some have base functionality. Use `super.<methodname>();`. Example below
```java
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
  System.out.println("Ponging");  
 break;  }  
    }  
  
}
```
Calling super.OnCommand allows Command_Interface's implementation to support the end implementation

**IMPORTANT**
Only classes that interact directly with the bot need to extend off of one of the Module_Interface classes.
Module_Interface itself doesn't do anything, don't use it.

### Step 3a: Creating/Opening the relevant file
Now, if you've ever played modded minecraft in the good ol' days, you had to delete a META-INF file. This served the purpose of letting the mod's META-INF file to tell minecraft what stuff to load. Same idea here, but you don't delete it; you change it.

First, navigate to `src/main/resources/META-INF/Services`
Then, look for a file. It should be named `core.<yourmoduleinterface>`

\<yourmoduleinterface\> is the Module_Interface that you extended off of

For example, if you have
Module_Interface: Module_Interface_Event
`core.Module_Interface_Event` is what the file should be named.

### Step 3b: Editing the relevant file
After finding/creating the file, open it with your editor. Inside, put `<yourpackage>.<youractionclassname>`
For example, if you have the class 'Ping' under 'ExampleModules', you'll put
`ExampleModules.Ping`
Once you placed all the classes that you extend off of one of the Module_Interfaces, save and close your file.

### Step 4: Testing
Hopefully your logic doesn't cause any bugs. If there's a bug that's caused by the core package or coremodules, please open an issue on the github issue tracker, **AFTER** reading the common errors below. Please Please Please test your work before making a pull request.


## Common errors


### FileNotFoundException in BotInit
You most likely got this when first testing the bot. You're missing a Token.json under `src/main/json`. Add it and your bot token for testing. No, I am not releasing my bot token for obvious reasons, make a bot through discord dev portal yourself.
