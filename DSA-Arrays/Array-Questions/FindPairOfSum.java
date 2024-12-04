public class FindPairOfSum {
    public static void main(String[] args) {

        int[] arr = {1,2,3,4,5,6,7};
        pairOfSum(arr,9);
    }


    static void pairOfSum(int[] arr, int sum){
        int low=0;
        int high = arr.length-1;
        while (low < high){
            if(arr[low] + arr[high] < sum){
                low++;
            }
            if(arr[low] + arr[high] > sum){
                high--;
            }
            if (arr[low]+ arr[high] == sum){
                System.out.println("[" + arr[low] + "," + arr[high] + "]");
                high--;
                low++;
            }
        }
    }
}
