import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class DataReader {

    private BufferedReader reader;
    private String file ;
    String line = "";

    private ArrayList<Iris> product=new ArrayList<>();


    public ArrayList<Iris> readfile(String path,String trainOrTest) {

        file=path;

        try {
            reader = new BufferedReader(new FileReader(file));
            reader.readLine();
            System.out.println("hello");
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");

                if(trainOrTest.equalsIgnoreCase("train")){

                    product.add(new Iris(Double.parseDouble(data[1]),Double.parseDouble(data[2]),Double.parseDouble(data[3]),Double.parseDouble(data[4]),data[5]));
                }

                else {

                    product.add(new Iris(Double.parseDouble(data[1]),Double.parseDouble(data[2]),Double.parseDouble(data[3]),Double.parseDouble(data[4]),null));
                }


            }

            System.out.println(product);

        } catch (Exception e) {
            e.printStackTrace();

        }

        return product;
    }
}
