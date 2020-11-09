package Commands;

import BotPackeges.DiscordEntity.CommandEntity;
import BotPackeges.Resourses.CommandsList;
import Commands.SingleCommands.Help;

import java.util.ArrayList;

public class AddCommands {

    ArrayList<CommandEntity> Commands = new ArrayList<>();

    public AddCommands() {
        // here you add all your commands.
        Commands.add(new Help());

        // adding commands to bot.
        new CommandsList().addCommands(Commands);
    }
}
