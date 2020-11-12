package Commands;

import BotPackeges.DiscordEntity.CommandEntity;
import BotPackeges.Settings.Singleton;

import java.io.File;
import java.lang.reflect.Constructor;

import java.util.ArrayList;


public class AddCommands extends java.lang.ClassLoader {
    ArrayList<CommandEntity> Commands = new ArrayList<>();

    public void InitializeCommands() {
        // get all command file names.
        File[] files = new File("./src/main/java/Commands/SingleCommands").listFiles();
        //If this pathname does not denote a directory, then listFiles() returns null.

        for (File file : files) {
            if (file.isFile()) {
                // get only the file name without .java
                String[] parts = file.getName().split("[.]");
                String Commandname = parts[0];
                Commands.add(invokeClassMethod(Commandname));
            }
        }
        Singleton.getInstance().commands = Commands;
    }


    public CommandEntity invokeClassMethod(String Command) {
        try {
            // Create a new JavaClassLoader
            ClassLoader classLoader = this.getClass().getClassLoader();

            // Load the target class using its binary name
            Class loadedCommand = classLoader.loadClass("Commands.SingleCommands." + Command);
            System.out.println("Loaded class name: " + loadedCommand.getName());

            // Create a new instance from the loaded class
            Constructor constructor = loadedCommand.getConstructor();
            CommandEntity CommandObject = (CommandEntity) constructor.newInstance();
            System.out.println(CommandObject.getCommandName());
            return CommandObject;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
