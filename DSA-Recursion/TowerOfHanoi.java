public class TowerOfHanoi {

    static void hanoi(int n, char source, char dest, char aux) {

        if (n == 1) {
            System.out.println("Base: " + source + "-->" + dest);
        } else {
            hanoi(n - 1, source, aux, dest);
            System.out.println("Take disk: " + n + " to destination");
            hanoi(n - 1, aux, dest, source);
        }
    }

    public static void main (String[] args){
        int n = 3;
        hanoi(n, 'A', 'C', 'B');
    }
}
