import java.util.ArrayList;
import java.util.Comparator;

public class Test {

    public static void main(String args[]){

        Integer[] l = {1, 2, 3, 5, 8, 9};

        sortNumbers(l);

    }

    public static void sortNumbers(Integer[] intArray){

        ArrayList<Integer> firstArray = new ArrayList<Integer>();
        ArrayList<Integer> secondArray = new ArrayList<Integer>();

        for (int number:intArray) {
            if(number%2==0){
                firstArray.add(number);
            }else {
                secondArray.add(number);
            }
        }

        ArrayList<Integer> sortedFirstArray = sortNumbers(firstArray, "DESC");
        ArrayList<Integer> sortedSecondArray = sortNumbers(secondArray, "ASC");

        System.out.println("First Array"+sortedFirstArray);
        System.out.println("Second Array"+sortedSecondArray);

    }

    public static ArrayList<Integer> sortNumbers(ArrayList<Integer> arrNumbers, String order){
        ArrayList<Integer> sortedArray;

        if(order.equalsIgnoreCase("ASC")){
            arrNumbers.sort(Comparator.naturalOrder());
        }else {
            arrNumbers.sort(Comparator.reverseOrder());
        }

        sortedArray = arrNumbers;

        return sortedArray;
    }

}
