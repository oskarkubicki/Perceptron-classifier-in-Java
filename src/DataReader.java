import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class DataReader {

    private BufferedReader reader;
    private String file ;
    String line = "";

    private ArrayList<Iris> product;


    public ArrayList<Iris> readfile(String path) {

        file=path;

        try {
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");


                System.out.println(data[0]);








                
            }







        } catch (Exception e) {
            e.printStackTrace();

        }

        return product;
    }
}
