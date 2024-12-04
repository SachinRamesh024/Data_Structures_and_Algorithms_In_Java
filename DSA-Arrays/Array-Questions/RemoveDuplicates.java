public class RemoveDuplicates {
    public static void main(String[] args) {

        int[] arr = {1,2,4,4,6,6,7};
        removeDuplicates(arr);
        print(arr,7);
    }

    static void removeDuplicates(int[] arr){
        int j=0;
        for(int i = 0; i < arr.length-1 ; i++) {
            if(arr[i] != arr[i+1]){
                arr[j++] = arr[i];
            }
        }
        arr[j++] = arr[arr.length-1];

        for (int k=0; k<j; k++){
            System.out.print(arr[k] + " ");
        }
        System.out.println();
    }

    static void print(int[] arr, int size){
        for (int i = 0; i <size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
