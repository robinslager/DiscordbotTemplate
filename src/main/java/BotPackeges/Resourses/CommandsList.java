package BotPackeges.Resourses;


import BotPackeges.DiscordEntity.CommandEntity;
import BotPackeges.Settings.Singleton;

import java.util.ArrayList;

public class CommandsList {


    public void addCommands(ArrayList<CommandEntity> commandEntity){
        Singleton.getInstance().commands = commandEntity;
    }

    public ArrayList<CommandEntity> ReturnCommands(){
        return Singleton.getInstance().commands;
    }
}
