import java.io.*;

/**
 * Criado por Mariana
 * Data: 14/09/2019
 **/
public class Main {
    public static void main(String[] args) {
        Buffer buffer = new Buffer();

        File file = new File("urls.txt");
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(file));
            String text = null;

            while ((text = reader.readLine()) != null) {
                new ReadURL(text, buffer).start();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {

            }
        }
    }
}
