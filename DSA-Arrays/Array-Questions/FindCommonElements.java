public class FindCommonElements {
    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4,5};
        int[] arr2 = {3,4,5,6};
        int[] arr3 = {4,5,9,10};
        commonElements(arr1,arr2,arr3);

    }

    static void commonElements(int[] arr1, int[] arr2, int[] arr3){
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                for (int k = 0; k < arr3.length; k++) {
                    if(arr1[i] == arr2[j] && arr2[j] == arr3[k]){
                        System.out.print(arr1[i] + " ");
                    }
                }
            }
        }
        System.out.println();
    }
}
