package BotPackeges;

import BotPackeges.DiscordEvents.OnGuildJoin;
import BotPackeges.DiscordEvents.OnMessageRecieved;
import BotPackeges.DiscordEvents.OnReactionAdded;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.guild.GuildJoinEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.MemberCachePolicy;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;
import javax.security.auth.login.LoginException;
public class bot extends ListenerAdapter {
    private Message msg;

    @Override
    public void onGuildJoin(@NotNull GuildJoinEvent event) {
        // event
        new OnGuildJoin(event);
    }
    // todo on guild leave delete data

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        // event
        new OnMessageRecieved(event);
    }

    @Override
    public void onMessageReactionAdd(@Nonnull MessageReactionAddEvent event) {
        new OnReactionAdded(event);
    }
}