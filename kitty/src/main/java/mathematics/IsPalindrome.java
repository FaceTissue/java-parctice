package mathematics;

/**
 * 9.是否回文数
 */
public class IsPalindrome {
    public boolean isPalindrome(int x) {
        int reverted = 0;
        while (x > reverted) {
            int pop = x % 10;
            reverted = reverted * 10 + pop;
            x /= 10;
        }
        return x == reverted || x == reverted / 10;
    }
}
