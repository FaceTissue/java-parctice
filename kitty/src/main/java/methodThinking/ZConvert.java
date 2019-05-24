package methodThinking;

/**
 * 6.Z字形变换
 */
public class ZConvert {
    // 按行访问
    public String convert(String s, int numRows) {
        if (1 == numRows) return s;
        StringBuilder[] sbs = new StringBuilder[numRows];
        for (int i = 0; i < sbs.length; i++) sbs[i] = new StringBuilder();
        boolean flag = false;
        for (int i = 0, j = 0; i < s.length(); i++) {
            sbs[j].append(s.charAt(i));
            if (j == 0 || j == numRows - 1) flag = !flag;
            j = flag ? j + 1 : j - 1;
        }
        String result = "";
        for (StringBuilder sb : sbs) {
            result += sb.toString();
        }
        return result;
    }

}
