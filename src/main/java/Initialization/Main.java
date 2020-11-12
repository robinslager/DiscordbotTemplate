package Initialization;


import BotPackeges.bot;
import Commands.AddCommands;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.MemberCachePolicy;

import javax.security.auth.login.LoginException;

public class Main  extends ListenerAdapter {

    public static void main(String[] args) throws LoginException {

        new AddCommands().InitializeCommands();
        String Token = "INSERT KEY HERE";
        JDABuilder.createDefault(Token).setMemberCachePolicy(MemberCachePolicy.ALL).enableIntents(GatewayIntent.GUILD_MEMBERS).addEventListeners(new bot()).build();
    }

}

