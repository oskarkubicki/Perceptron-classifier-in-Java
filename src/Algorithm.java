import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class Algorithm {

    private ArrayList<Iris> training_data;
    private ArrayList<Iris> test_data;
    private Iris single;

    public void mainloop() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Input k");
        String k = scanner.next();
        System.out.println("input path to training data");
        String data_path = scanner.next();
        DataReader dataReader = new DataReader();
        training_data = dataReader.readfile(data_path, "train");

        System.out.println("To classify Iristrain.csv input [1]\n" +
                "to classify a single Iris input [2]");
        String userchoice=scanner.next();

        if(userchoice.equalsIgnoreCase("1")){

            System.out.println("input path to test data");
            String data_path1 = scanner.next();
            DataReader dataReader1 = new DataReader();
            test_data = dataReader1.readfile(data_path1, "test");
            FindDistances();
            PredictType(Integer.parseInt(k));
            Accuracy();
        }else if(userchoice.equalsIgnoreCase("2")){

            System.out.println("Input sepal length and width and petal leght and width");

          String  input=scanner.next();
            System.out.println("Input sepal width ");

            String input1=scanner.next();

            System.out.println("input petal length");

            String inpu2=scanner.next();

            System.out.println("input petal width");


            String input3=scanner.next();

            Iris iris =new Iris(Double.parseDouble(input), Double.parseDouble(input1), Double.parseDouble(inpu2), Double.parseDouble(input3), null, null);

            FindDistancesSingle(iris);

            PredictTypeSingle(Integer.parseInt(k), iris);



        }


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


    public void FindDistancesSingle(Iris iris) {

        double distance;


            for (int j = 0; j < training_data.size(); j++) {


                distance = Math.sqrt(Math.pow(iris.getSepal_width() - training_data.get(j).getSepal_width(), 2) +Math.pow(iris.getSepal_length() - training_data.get(j).getSepal_length(), 2)+ Math.pow(iris.getPetal_width() - training_data.get(j).getPetal_width(), 2)+Math.pow(iris.getPetal_legth() - training_data.get(j).getPetal_legth(), 2));
                iris.getDistances().put(distance, training_data.get(j).getIrisType());
            }

    }
    public void PredictType(int k) {
        int a=k;
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

            if (counterSetosa > counterVersicolor && counterSetosa > counterVirginica) {

                test_data.get(i).setIrisType(IrisType.Setosa);
                System.out.println("Predicted type:" + test_data.get(i).getIrisType() + " Actual type" + test_data.get(i).getActualType());
                counterSetosa=0;
                counterVersicolor=0;
                counterVirginica=0;
                k=a;

            } else if (counterVersicolor > counterSetosa && counterVersicolor > counterVirginica) {


                test_data.get(i).setIrisType(IrisType.Versicolor);
                System.out.println("Predicted type:" + test_data.get(i).getIrisType() + " Actual type" + test_data.get(i).getActualType());

                counterSetosa=0;
                counterVersicolor=0;
                counterVirginica=0;
                k=a;

            } else if (counterVirginica > counterSetosa && counterVirginica > counterVersicolor) {

                test_data.get(i).setIrisType(IrisType.Virginica);
                System.out.println("Predicted type:" + test_data.get(i).getIrisType() + " Actual type" + test_data.get(i).getActualType());

                counterSetosa=0;
                counterVersicolor=0;
                counterVirginica=0;
                k=a;
            }
        }
    }



    public void PredictTypeSingle(int k,Iris iris) {
        int a=k;
        int counterSetosa = 0;
        int counterVersicolor = 0;
        int counterVirginica = 0;


            for (Map.Entry<Double, IrisType> entry : iris.getDistances().entrySet()
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

            if (counterSetosa > counterVersicolor && counterSetosa > counterVirginica) {

                iris.setIrisType(IrisType.Setosa);
                System.out.println("Predicted type:" + iris.getIrisType() + " Actual type" + iris.getActualType());
                counterSetosa=0;
                counterVersicolor=0;
                counterVirginica=0;
                k=a;

            } else if (counterVersicolor > counterSetosa && counterVersicolor > counterVirginica) {


                iris.setIrisType(IrisType.Versicolor);
                System.out.println("Predicted type:" + iris.getIrisType() + " Actual type" + iris.getActualType());

                counterSetosa=0;
                counterVersicolor=0;
                counterVirginica=0;
                k=a;

            } else if (counterVirginica > counterSetosa && counterVirginica > counterVersicolor) {

                iris.setIrisType(IrisType.Virginica);
                System.out.println("Predicted type:" + iris.getIrisType() + " Actual type" + iris.getActualType());

                counterSetosa=0;
                counterVersicolor=0;
                counterVirginica=0;
                k=a;
            }
        }


    public void Accuracy (){

        int counter=0;


        for (int i=0;i<test_data.size();i++){

            if(test_data.get(i).getIrisType().nazwa.equalsIgnoreCase(test_data.get(i).getActualType().nazwa)){

                counter++;

            }

        }

        double accuracy=(double)counter/50;

        System.out.println("accuracy is "+accuracy+"%");

    }

}