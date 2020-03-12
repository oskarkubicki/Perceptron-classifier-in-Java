import java.util.TreeMap;

public class Iris {
    private double sepal_length;
    private double sepal_width;
    private double petal_legth;
    private double petal_width;
    private IrisType irisType;
    private TreeMap<Double,IrisType> distances;
    private IrisType actualType;



    public Iris(double sepal_length, double sepal_width, double petal_legth, double petal_width, String irisType, String actualType) {
        this.sepal_length = sepal_length;
        this.sepal_width = sepal_width;
        this.petal_legth = petal_legth;
        this.petal_width = petal_width;

        if(irisType==null){
            this.irisType=null;
        }
        else if(irisType.substring(1, irisType.length()-1).equalsIgnoreCase("setosa")){

            this.irisType=IrisType.Setosa;
        }else if (irisType.substring(1, irisType.length()-1).equalsIgnoreCase("versicolor")){

            this.irisType=IrisType.Versicolor;
        }else if (irisType.substring(1, irisType.length()-1).equalsIgnoreCase("virginica")){

            this.irisType=IrisType.Virginica;
        }




        if(irisType.substring(1, irisType.length()-1).equalsIgnoreCase("setosa")){

            this.actualType=IrisType.Setosa;
        }else if (irisType.substring(1, irisType.length()-1).equalsIgnoreCase("versicolor")){

            this.actualType=IrisType.Versicolor;
        }else if (irisType.substring(1, irisType.length()-1).equalsIgnoreCase("virginica")){

            this.actualType=IrisType.Virginica;
        }

        else {

            this.actualType=null;
        }
    }

    public double getSepal_length() {
        return sepal_length;
    }

    public void setSepal_length(double sepal_length) {
        this.sepal_length = sepal_length;
    }

    public double getSepal_width() {
        return sepal_width;
    }

    public void setSepal_width(double sepal_width) {
        this.sepal_width = sepal_width;
    }

    public double getPetal_legth() {
        return petal_legth;
    }

    public void setPetal_legth(double petal_legth) {
        this.petal_legth = petal_legth;
    }

    public double getPetal_width() {
        return petal_width;
    }

    public void setPetal_width(double petal_width) {
        this.petal_width = petal_width;
    }

    public IrisType getIrisType() {
        return irisType;
    }

    public void setIrisType(IrisType irisType) {
        this.irisType = irisType;
    }

    public TreeMap<Double, IrisType> getDistances() {
        return distances;
    }

    public void setDistances(TreeMap<Double, IrisType> distances) {
        this.distances = distances;
    }


    public IrisType getActualType() {
        return actualType;
    }

    public void setActualType(IrisType actualType) {
        this.actualType = actualType;
    }


    @Override
    public String toString() {
        return "Iris{" +
                "sepal_length=" + sepal_length +
                ", sepal_width=" + sepal_width +
                ", petal_legth=" + petal_legth +
                ", petal_width=" + petal_width +
                ", irisType=" + irisType +
                ", distances=" + distances +
                ", actualType=" + actualType +
                '}';
    }
}