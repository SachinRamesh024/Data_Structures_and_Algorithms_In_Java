import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {-10,-5,0,1,3,2,7};
        bubble(arr);
        System.out.println(Arrays.toString(arr));
    }

    public  static void bubble(int[] arr){
        for (int i = 0; i < (arr.length-1); i++) {
            boolean swapped = false;
            for (int j = 0; j < arr.length - 1 - i; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swapped = true;
                }
            }
            if(!swapped){
                break;
            }
        }
    }
}
