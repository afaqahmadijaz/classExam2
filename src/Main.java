import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        int [] originalArray = {2,5,9,23,50,99,76,89,33,40};
        System.out.println("This is the original unsorted Array: " + Arrays.toString(originalArray));

        int[] sortedArray = ArraySort(originalArray);
        System.out.println("This is when the Array is sorted:   " + Arrays.toString(sortedArray));

    }

    public static int[] ArraySort(int[] array) {
        if (array.length == 0){
            return array;
        }
        else if (array.length == 1){
            return array;
        }

        int splitPoint = array[array.length/2];

        List<Integer> smaller = new ArrayList<>();
        List<Integer> larger = new ArrayList<>();

        for (int i : array) {
            if (i < splitPoint)
                smaller.add(i);
            else if (i > splitPoint)
                larger.add(i);
        }

        int[] sortedSmaller = ArraySort(smaller.stream().mapToInt(Integer::intValue).toArray());
        int[] sortedLarger = ArraySort(larger.stream().mapToInt(Integer::intValue).toArray());

        int[] result = new int[sortedSmaller.length + 1 + sortedLarger.length];
        System.arraycopy(sortedSmaller, 0, result, 0, sortedSmaller.length);
        result[sortedSmaller.length] = splitPoint;
        System.arraycopy(sortedLarger, 0, result, sortedSmaller.length + 1, sortedLarger.length);

        return result;
    }

}