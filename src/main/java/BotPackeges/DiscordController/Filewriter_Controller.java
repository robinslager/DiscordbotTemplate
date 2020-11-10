package BotPackeges.DiscordController;

import org.json.JSONObject;

import java.io.*;
import java.nio.file.Files;


public class Filewriter_Controller {
    private File file;

    public Filewriter_Controller() {
        file = new File("server_variables.json");
    }

    // write the content in file
    public void write(JSONObject text) {
        try {
            PrintWriter writer = new PrintWriter(file);
            writer.write(text.toString(2));
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    // reading the content of file
    public String read() {
        try {
            BufferedReader br = Files.newBufferedReader(file.toPath());
            String line = br.readLine();
            StringBuilder sb = new StringBuilder();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            br.close();
            return sb.toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
