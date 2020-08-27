package coremodules;

public class User{
    public net.dv8tion.jda.api.entities.User JDAUser;
    public int Standing = 0;
    public String ID;


    public User(net.dv8tion.jda.api.entities.User JDAUser){
        this.JDAUser = JDAUser;
        this.ID = JDAUser.getId();
    }
}
