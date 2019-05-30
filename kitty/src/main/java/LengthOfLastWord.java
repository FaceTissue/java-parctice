import org.junit.Test;

public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        if (s.length() == 0) return 0;
        int len = 0, start = s.length() - 1;
        while (start >= 0 && s.charAt(start) == ' ') {
            start--;
        }
        while (start >= 0 && s.charAt(start) != ' ') {
            len++;
            start--;
        }
        return len;
    }

    @Test
    public void lengthOfLastWordTest() {
        System.out.println(lengthOfLastWord("a "));
    }
}
