import java.util.Arrays;

public class FindOriginalIndicesofSortedArrayElements {
    public static void main(String[] args) {

        int[] unsorted = {4,5,3,7,1};

        int[] copy = Arrays.copyOf(unsorted,unsorted.length);

        Arrays.sort(unsorted);

        System.out.println("Original indices");
        for(int sortedEelement : unsorted){
            for (int i = 0; i < copy.length; i++) {
                if(copy[i] ==sortedEelement){
                    System.out.print(i +" ");
                }
            }
        }
    }
}
