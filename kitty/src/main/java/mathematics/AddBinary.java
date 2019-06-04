package mathematics;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class AddBinary {
    // my solution
    public String addBinary(String a, String b) {
        List<Integer> list = new ArrayList<>();
        int a_idx = a.length() - 1, b_idx = b.length() - 1, carry = 0;
        while (a_idx >= 0 || b_idx >= 0) {
            int a_num = a_idx >= 0 ? a.charAt(a_idx) - '0' : 0;
            int b_num = b_idx >= 0 ? b.charAt(b_idx) - '0' : 0;
            int sum = a_num + b_num + carry;
            list.add(sum % 2);
            carry = sum / 2;
            if (a_idx >= 0) a_idx--;
            if (b_idx >= 0) b_idx--;
        }
        StringBuilder res = new StringBuilder(carry > 0 ? "1" : "");
        for (int i = list.size() - 1; i >= 0; i--) res.append(list.get(i));
        return res.toString();
    }

    // optimized
    public String addBinary1(String a, String b) {
        StringBuilder res = new StringBuilder();
        int a_idx = a.length() - 1, b_idx = b.length() - 1, carry = 0;
        while (a_idx >= 0 || b_idx >= 0 || carry != 0) {
            int a_num = a_idx >= 0 ? a.charAt(a_idx--) - '0' : 0;
            int b_num = b_idx >= 0 ? b.charAt(b_idx--) - '0' : 0;
            int sum = a_num + b_num + carry;
            res.append(sum % 2);
            carry = sum / 2;
        }
        return res.reverse().toString();
    }
    @Test
    public void addBinaryTest() {
        System.out.println(addBinary("110", "11"));
    }
}
