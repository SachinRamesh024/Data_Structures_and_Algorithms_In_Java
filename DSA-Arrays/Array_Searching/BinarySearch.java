public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {10,20,30,40,50,60,70};
        
        int result = BinarySearch(arr,40);
        if(result!=-1){
            System.out.println("Element found at index: "+result);
        } else{
            System.out.println("Element not found");
        }
    }

    public static int BinarySearch(int[] arr, int target){
        int start = 0;
        int end = arr.length-1;
        while (start <=end){
            int mid = start + (end-start) / 2;

            if(arr[mid] == target){
                return mid;
            }
            if(arr[mid] < target){
                start = mid+1;
            }
            if(arr[mid] > target){
                end = mid-1;
            }
        }
        return -1;
    }
}
