package datastructures.binarysearchtree.recursion;

/**
 * 階乘 (Factorial) 公式：
 * - n! = n * (n - 1)!
 * - 例：4! = 4 * 3!
 * <p>
 * Base Case： 1! = 1 || 0! = 1
 * - 因為 1! 與 0! 結果都為 1
 */
public class Factorial {

    public static int factorial(int n) {
        if (n == 1 || n == 0) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        int result = factorial(0);
        System.out.println(result);
    }
}
