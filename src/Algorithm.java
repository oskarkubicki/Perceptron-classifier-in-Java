import java.util.ArrayList;
import java.util.Scanner;

public class Algorithm {

    private ArrayList<Iris> training_data;
    private ArrayList<Iris> test_data;




    public void mainloop(){

        Scanner scanner=new Scanner(System.in);


        System.out.println("Input k");

        String k= scanner.next();

        System.out.println("input path to training data");

        String data_path=scanner.next();

        DataReader dataReader =new DataReader();


        training_data=dataReader.readfile(data_path);




    }




}
