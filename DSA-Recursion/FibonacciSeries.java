public class FibonacciSeries {

    public static long FibonacciRecursive(int n){

        if(n<1) return 0;

        if (n<3) return 1;

        return FibonacciRecursive(n-1)+ FibonacciRecursive(n-2);
    }

    public static long FibonacciIterative(int n){
        long a =0, b= 1;
        long c=0;

        for (int i = 1; i <=n ; i++) {
            c = a+b;
            a=b;
            b=c;
        }
        return c;
    }

    public static void main(String[] args) {

        for (int i = 30; i <=40 ; i++) {
            long t0 = System.currentTimeMillis();
            long m = FibonacciRecursive(i);
            long t1 = System.currentTimeMillis();
            System.out.println("Fibonacci(recurive) of " +i+ " is= " +m + " Time: " + (t1-t0) + " ms");
        }
    }
}

