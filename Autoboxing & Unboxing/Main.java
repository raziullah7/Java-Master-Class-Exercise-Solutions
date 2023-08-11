import java.util.ArrayList;

class intClass {
    private int value;

    public intClass(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}


public class Main {

    public static void main(String[] args) {
        // this works because String is not a primitive type
        ArrayList<String> stringArrayList = new ArrayList<>();

        // this does not work because int is a primitive type
        // ArrayList<int> intArrayList = new ArrayList<>();

        // we could do this
        ArrayList<intClass> intClassArrayList = new ArrayList<>();
        intClassArrayList.add(new intClass(54));
        Integer integer = Integer.valueOf(54);       // unnecessary but preferred
        Integer integer1 = 54;

        Double doubleValue = Double.valueOf(12.25); // unnecessary but preferred
        Double doubleValue2 = 12.25;

        ArrayList<Integer> intArrayList = new ArrayList<>();
        for (int i = 0; i <= 10; i++) {
            // auto boxing (converting primitive type into class object)
            intArrayList.add(Integer.valueOf(i));
        }

        for (int i = 0; i <= 10; i++) {
            // unboxing (converting class object into primitive type)
            System.out.println(i + " -->" + intArrayList.get(i).intValue());
        }


        // shorter way
        // auto boxing
        Integer myIntValue = 56;    // Integer myIntValue =Integer.valueOf(56);
        // unboxing
        int myInt = myIntValue;     // int myInt = myIntValue.intValue();


        ArrayList<Double> myDoubleValues = new ArrayList<>();
        // auto boxing
        for (double dbl = 0.0; dbl <= 10.0; dbl += 0.5) {
            // longer way
            myDoubleValues.add(Double.valueOf(dbl));    // myDoubleValues.add(dbl);
        }

        // unboxing
        for (int i = 0; i < myDoubleValues.size(); i++) {
            // longer way
            double value = myDoubleValues.get(i).doubleValue(); // double value = myDoubleValues.get(i);
            System.out.println(i + " --> " + value);
        }
    }
}
