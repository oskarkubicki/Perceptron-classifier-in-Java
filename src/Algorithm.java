import java.util.ArrayList;
import java.util.Map;
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

        DataReader dataReader1=new DataReader();
        test_data = dataReader1.readfile(data_path1, "test");


        FindDistances();
        PredictType(Integer.parseInt(k));


    }

    public void FindDistances() {

        double distance;

        for (int i = 0; i < test_data.size(); i++) {
            for (int j = 0; j < training_data.size(); j++) {

                distance = Math.sqrt(Math.pow(test_data.get(i).getSepal_width() - training_data.get(j).getSepal_width(), 2) + Math.pow(test_data.get(i).getPetal_width() - training_data.get(j).getPetal_width(), 2));

                test_data.get(i).getDistances().put(distance, training_data.get(j).getIrisType());
            }
        }
    }

    public void PredictType(int k) {
        int counterSetosa = 0;
        int counterVersicolor = 0;
        int counterVirginica = 0;
        for (int i = 0; i < test_data.size(); i++) {

            for (Map.Entry<Double, IrisType> entry : test_data.get(i).getDistances().entrySet()
            ) {
                if (k == 0) {
                    break;
                }
                if (entry.getValue().nazwa.equalsIgnoreCase("setosa")) {

                    counterSetosa++;
                    k--;

                } else if (entry.getValue().nazwa.equalsIgnoreCase("versicolor")) {

                    counterVersicolor++;
                    k--;
                } else {

                    counterVirginica++;
                    k--;
                }
            }

            if(counterSetosa>counterVersicolor&&counterSetosa>counterVirginica){



                System.out.println("Predicted type: Virginica Setosa "+" Actual type"+test_data.get(i).getIrisType());

            }
        }

    }

}