public class InsertSortedArray {
    // Inserts a key in arr[] of given capacity.
    // n is current size of arr[].
    // This function returns n+1 if insertion is successful, else n.

    static int insertSorted(int[] arr,int n,int key, int capacity){
        if(n >= capacity)
            return n;

        int i;
        for (i = n-1; (i>=0 && key <arr[i]) ; i--)
            arr[i+1] = arr[i];

            arr[i+1] = key;

            return (n+1);

    }

    public static void main(String[] args) {
        int[] arr = new int[20];
        arr[0] = 10;
        arr[1] = 20;
        arr[2] = 30;
        arr[3] = 40;
        arr[4] = 50;
        arr[5] = 60;
        int capacity = arr.length;
        int n =6;
        int key = 26;

        System.out.println("Before insertion: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }

        n= insertSorted(arr,n,key,capacity);

        System.out.println("\n After insertion: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }

    }
}
