import java.util.ArrayList;
import java.util.List;

public class PalindromeNumber {
    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(120));
    }

    private static boolean isPalindrome(int x) {
        if (x < 0) return false;
        else if (x == 0) return true;
        else {
            List<Character> characters = new ArrayList<>();
            while (x != 0) {
                int pop = x % 10;
                characters.add((char) pop);
                x = x / 10;
            }
            int size = characters.size();
            for (int i = 0; i <= size / 2; i++) {
                if (characters.get(i) != characters.get(size - 1 - i)) return false;
            }
            return true;
        }
    }

    private static boolean isPalindrome1(int x) {
        if (x < 0 || (x !=0 && x % 10 == 0)) return false;
        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }
        return x == revertedNumber || revertedNumber / 10 == x;
    }
}


