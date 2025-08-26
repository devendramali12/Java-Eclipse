package box4;

public class NumberSwap {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        int temp;

        temp = a;  // store a
        a = b;     // assign b to a
        b = temp;  // assign temp (old a) to b

        System.out.println("After Swapping:");
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }
}
