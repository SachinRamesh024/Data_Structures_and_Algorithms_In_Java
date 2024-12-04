public class ArrayMinMax {

    static int max(int[] arr){
        int max = arr[0];
        for (int i = 0; i < arr.length ; i++) {
            if(arr[i] > max){
                max = arr[i];
            }
        }
        return max;
    }

    static int min(int[] arr){
        int min = arr[0];
        for(int i=0; i< arr.length; i++){
            if(arr[i] < min){
                min = arr[i];
            }
        }
        return min;
    }
    public static void main(String[] args) {

        int[] arr = {1, 5, 4, 2, 3, 8};

        int resultMax = max(arr);
        System.out.println("Max number in array is: " +resultMax);
        int resultMin = min(arr);
        System.out.println("Min number in array is: " +resultMin);

    }
}
