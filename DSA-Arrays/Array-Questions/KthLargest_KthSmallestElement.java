public class KthLargest_KthSmallestElement {
       public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        KthLargest(arr,3);
        KthSmallest(arr,2);

     }

    static void print(int[] arr, int size) {
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    static void KthLargest(int[] arr, int k) {
        //sorting in descending order
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] < arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
            if (i == k - 1) {
                System.out.println(k + " largest element: " + arr[i]);
                break;
            }
        }
    }

    static void KthSmallest(int[] arr, int k) {
        //sorting in ascending order
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
            if (i == k - 1) {
                System.out.println(k + " smallest element: " + arr[i]);
                break;
            }
        }
    }

}
