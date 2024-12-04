import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {-10,-5,0,1,3,2,7};
        selection(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void selection(int[] arr){
        for (int i = 0; i < arr.length-1; i++) {
            int minIndex = i;
            for (int j = i+1; j <arr.length ; j++) {
                if(arr[j]< arr[minIndex]){
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }
}
