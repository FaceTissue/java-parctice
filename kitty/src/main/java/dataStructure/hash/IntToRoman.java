package dataStructure.hash;

/**
 * 12.整数转罗马数字
 */
public class IntToRoman {
    // my solution
    public String intToRoman(int num) {
        String ans = "";
        int idx = 0;
        while (num != 0) {
            int tail = num % 10;
            if (tail == 4) {
                switch (idx) {
                    case 0:
                        ans = "IV" + ans;
                        break;
                    case 1:
                        ans = "XL" + ans;
                        break;
                    case 2:
                        ans = "CD" + ans;
                        break;
                }
            } else if (tail == 9) {
                switch (idx) {
                    case 0:
                        ans = "IX" + ans;
                        break;
                    case 1:
                        ans = "XC" + ans;
                        break;
                    case 2:
                        ans = "CM" + ans;
                        break;
                }
            } else {
                String temp = "";
                switch (idx) {
                    case 0:
                        if (tail >= 5) {
                            temp = temp + "V";
                            tail -= 5;
                        }
                        for (int i = 0; i < tail; i++) temp = temp + "I";
                        break;
                    case 1:
                        if (tail >= 5) {
                            temp = temp + "L";
                            tail -= 5;
                        }
                        for (int i = 0; i < tail; i++) temp = temp + "X";
                        break;
                    case 2:
                        if (tail >= 5) {
                            temp = temp + "D";
                            tail -= 5;
                        }
                        for (int i = 0; i < tail; i++) temp = temp + "C";
                        break;
                    case 3:
                        for (int i = 0; i < tail; i++) temp = temp + "M";
                        break;
                }
                ans = temp + ans;
            }
            num /= 10;
            idx++;
        }
        return ans;
    }

    // hash
    public String intToRoman1(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] strs = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            int pop = num / values[i];
            if (pop == 0) continue;
            for (int j = pop; j > 0; j--) {
                sb.append(strs[i]);
            }
            num -= (pop * values[i]);
            if (num == 0) break;
        }
        return sb.toString();
    }
}
