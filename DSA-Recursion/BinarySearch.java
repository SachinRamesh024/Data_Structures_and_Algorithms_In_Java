public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {10,20,30,40,50,60,70};

        int result = binarySearch(arr,10,70,50);
        if(result!=-1){
            System.out.println("Element found at index: "+result);
        } else{
            System.out.println("Element not found");
        }
    }
    static int binarySearch(int arr[], int low, int high, int x){
        if (high >= low) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == x)
                return mid;

            if (arr[mid] > x)
                return binarySearch(arr, low, mid - 1, x);

            return binarySearch(arr, mid + 1, high, x);
        }
        return -1;
    }
}
