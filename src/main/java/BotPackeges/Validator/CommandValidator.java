package BotPackeges.Validator;

import BotPackeges.DiscordEntity.CommandEntity;

import BotPackeges.Validator.Singlevallidators.PermissionValidator;

public class CommandValidator {

    /**
     * @param Command CommandEntity.
     * to initialize everything.
     * with this i dont have to give anything else with the command.
     */
    private CommandEntity Command;

    public CommandValidator(CommandEntity command) {
        this.Command = command;
    }

    public Boolean validate(){
        if(new Validator.Singlevallidators.ArgumentValidator(Command).validate()){
            if(new PermissionValidator(Command).validate()){
                return true;
            }
        }
        return false;
    }
}
