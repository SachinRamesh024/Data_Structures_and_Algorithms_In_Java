public class Factorial {
    public static void FactorialIterative(int n){
        int a =1;
        for (int i = 1; i <=n ; i++) {
            a=a*i;
        }
        System.out.println("Factorial of " +n + " is: " +a);
    }

    static long FactorialRecursive(int n){
        if(n==1)
            return 1;

        return  n * FactorialRecursive(n-1);
    }


    public static void main(String[] args) {

        FactorialIterative(7);
        long fr = FactorialRecursive(7);
        System.out.println(fr);
    }
}
