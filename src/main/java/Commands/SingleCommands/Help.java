package Commands.SingleCommands;

import BotPackeges.DiscordEntity.CommandEntity;
import BotPackeges.DiscordEntity.HelpString;
import BotPackeges.Enum.ArgumentTypes;
import BotPackeges.Resourses.CommandsList;
import Commands.CommandLogic.Help.Help_Get_All_Commands;
import Commands.CommandLogic.Help.Help_Get_Single_Command;


import java.util.ArrayList;

import static BotPackeges.Enum.ArgumentTypes.NONE;
import static BotPackeges.Enum.ArgumentTypes.STRING;

public class Help extends CommandEntity {
    public Help() {
        this.CommandName = "Help";
        this.Arguments_Allowed = new int[]{0, 1};
        this.ArgumentTypes_Allowed = new ArgumentTypes[] {NONE, STRING};
        this.Help = new HelpString(
                new String[] {"CommandName"},
                new String[] {"the name of the command that you want to view."},
                new String[] {"CommandName"},
                "shows a description of all commands \n" +
                        "with no argument you get all commands.",
                "!help help"
        );
    }

    @Override
    public void Execute() {
        if (this.Settings.base.getArgs_length() == this.Arguments_Allowed[0]) {
           new Help_Get_All_Commands();
        } else {
           new Help_Get_Single_Command();
        }

    }

    public ArrayList<CommandEntity> getCommandslist(){
        return new CommandsList().ReturnCommands();
    }
}
