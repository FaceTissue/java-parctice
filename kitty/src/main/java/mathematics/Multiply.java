package mathematics;

/**
 * 43.字符串相乘
 */
public class Multiply {
    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) return "0";
        int[] res = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            for (int j = num2.length() - 1; j >= 0; j--) {
                res[i + j] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                if (i + j > 0 && res[i + j] >= 10) {
                    res[i + j - 1] += res[i + j] / 10;
                    res[i + j] %= 10;
                }
            }
        }
        StringBuilder resStr = new StringBuilder();
        for (int i = 0; i < res.length - 1; i++) resStr.append(res[i]);
        return resStr.toString();
    }
}
