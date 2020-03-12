import java.io.BufferedReader;
import java.io.FileReader;

public class DataReader {

    private BufferedReader reader;
    private String file ;
    String line = "";


    public void readfile(String path) {

        file=path

        try {
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");


                
            }
        } catch (Exception e) {
            e.printStackTrace();

        }


    }
}
