import java.util.ArrayList;
import java.util.Scanner;

public class Algorithm {

    private ArrayList<Iris> training_data;
    private ArrayList<Iris> test_data;


    public void mainloop() {

        Scanner scanner = new Scanner(System.in);


        System.out.println("Input k");

        String k = scanner.next();

        System.out.println("input path to training data");

        String data_path = scanner.next();

        DataReader dataReader = new DataReader();


        training_data = dataReader.readfile(data_path, "train");


        System.out.println("input path to test data");

        String data_path1 = scanner.next();


        test_data = dataReader.readfile(data_path1, "test");


    }

    public void FindDistances() {

        double distance;

        for (int i = 0; i < test_data.size(); i++) {
            for (int j = 0; j < training_data.size(); j++) {


                distance=Math.sqrt(Math.pow(test_data.get(i).getSepal_width()-training_data.get(j).getSepal_width(),2)+Math.pow(test_data.get(i).getPetal_width()-training_data.get(j).getPetal_width(),2));

                test_data.get(i).getDistances().put(distance,training_data.get(j).getIrisType());
            }

        }


    }


}
