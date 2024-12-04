public class LinearSearch {
    public static void main(String[] args) {
        int[] arr = {10,20,30,40,50,60,70};

        int result = LinearSearch(arr,30);
        if(result!=-1){
            System.out.println("Element found at index: "+result);
        } else{
            System.out.println("Element not found");
        }
    }

    public static int LinearSearch(int[] arr, int target){
        for(int i =0; i< arr.length; i++){
            if(arr[i]==target){
                return i;
            }
        }
        return -1;
    }
}