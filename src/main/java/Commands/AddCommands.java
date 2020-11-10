package Commands;

import BotPackeges.DiscordEntity.CommandEntity;
import BotPackeges.Resourses.CommandsList;
import Commands.SingleCommands.Help;

import java.util.ArrayList;

public class AddCommands {

    ArrayList<CommandEntity> Commands = new ArrayList<>();

    public AddCommands() {
        // todo dynamic class loading. (see fitforlife app for example)
        // here you add all your commands.
        Commands.add(new Help());

        // adding commands to bot.
        new CommandsList().addCommands(Commands);
    }
}
