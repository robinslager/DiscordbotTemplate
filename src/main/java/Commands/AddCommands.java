package Commands;

import BotPackeges.DiscordEntity.CommandEntity;
import BotPackeges.Resourses.CommandsList;
import Commands.SingleCommands.Help;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class AddCommands extends java.lang.ClassLoader {
    ArrayList<CommandEntity> Commands = new ArrayList<>();



    public AddCommands() {

        // here you add all your commands.
        Commands.add(new Help());

        // adding commands to bot.
        new CommandsList().addCommands(Commands);
    }


    public void invokeClassMethod(String Command) {
        try {
            // Create a new JavaClassLoader
            ClassLoader classLoader = this.getClass().getClassLoader();

            // Load the target class using its binary name
            Class loadedMyClass = classLoader.loadClass("Commands.SingleCommands." + Command);

            System.out.println("Loaded class name: " + loadedMyClass.getName());

            // Create a new instance from the loaded class
            Constructor constructor = loadedMyClass.getConstructor();
            Object myClassObject = constructor.newInstance();

            // Getting the target method from the loaded class and invoke it using its name
            Method method = loadedMyClass.getMethod("Execute");
            System.out.println("Invoked method name: " + method.getName());
            method.invoke(myClassObject);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
