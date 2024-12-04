
public class MajorityElement {
    public static void main(String[] args) {

        int[] arr = {1,2,3,3,3,3,7};

        int result = majorityElement(arr);
        if(result!=-1){
            System.out.println("Majority Element found : "+result);
        } else{
            System.out.println("Majority Element not found");
        }

    }

    static void print(int[] arr, int size){
        for (int i = 0; i <size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    static int majorityElement(int[] arr){
        int count =0;
        int el = -1;//dummy data
        for (int i = 0; i < arr.length; i++) {
            if(count == 0){
                 count=1;
                 el = arr[i];
            } else if (arr[i] == el) {
                count++;
            } else {
                count--;
            }
        }
        int count1=0;
        for (int i = 0; i< arr.length; i++){
            if(arr[i] == el)
                count1++;
        }
         if(count1 > (arr.length/2)){
             return el;
         }
         return -1;
    }
}