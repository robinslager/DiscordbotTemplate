package Validator.Singlevallidators;



import BotPackeges.DiscordEntity.CommandEntity;
import BotPackeges.Enum.ArgumentTypes;
import BotPackeges.Enum.Enum_ErrorType;
import BotPackeges.Validator.Singlevallidators.SingleValidator;

import java.util.regex.Pattern;

public class ArgumentValidator extends SingleValidator {

    /**
     * @param Command
     * Current command that is being executed.
     */
    private CommandEntity Command;

    /**
     * @param Arguments_Allowed
     * a int array with all amounts of arguments that may be used with a command.
     */
    private int[] Arguments_Allowed;

    /**
     * @param Arguments
     * All Arguments
     */
    private String[] Arguments;

    public ArgumentValidator(CommandEntity command) {
        Command = command;
        Arguments_Allowed = command.getArguments_Allowed();
        Arguments = command.getSettings().base.getArgs();
    }

    /**
     * checks if correct argument amount of arguments are given.
     * checks if correct argument types of arguments are given.
     *
     * @return boolean
     */
    @Override
    public boolean validate() {
        Boolean validate = false;
        for (int ArgumentAllowed_option : Arguments_Allowed) {
            if (Command.getSettings().base.getArgs_length() == ArgumentAllowed_option) {
                validate = true;
            }
        }
        // exeption is only set when validate isn`t true
        if (!validate) {
            Command.PushExeption(
                    Enum_ErrorType.Invalid_Amount_Arguments, true);
            return false;
        }


        // todo if there are more argument types than check for a type.
        if (Command.getArgumentTypes_Allowed().length != 0) {

            // boolean that registers if 1 of the arguments does not match the allowed argument types
            boolean argumentcheck = true;
            for (ArgumentTypes argumentTypes : Command.getArgumentTypes_Allowed()) {
                if (argumentTypes == ArgumentTypes.All) {
                    return true;
                }
                if (argumentTypes == ArgumentTypes.STRING) {

                    // loop trough all arguments and check on only string characters in the string.
                    for (String argument : Command.getSettings().base.getArgs()) {
                        if (!Pattern.matches("[a-zA-Z]+", argument)) {
                            // todo error
                            return false;
                        }
                    }
                    return true;
                }
                if (argumentTypes == ArgumentTypes.INTEGER) {
                    for (String argument : Command.getSettings().base.getArgs()) {
                        try {
                            int x = Integer.parseInt(argument);
                        } catch (NumberFormatException e) {
                            return false; //String is not an Integer
                        }
                    }
                    return true;
                }
            }
        } else {
            return true;
        }
        return false;
    }
}
