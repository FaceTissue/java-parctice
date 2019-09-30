package CompilersPrinciples.automata;

import org.junit.Test;

public class IsNumber {
    // my solution (failed)
    public boolean isNumber(String s) {
        if (s.length() == 0) return false;
        int l = 0, r = s.length() - 1;
        while (l <= r && s.charAt(l) == ' ') l++;
        while (l <= r && s.charAt(r) == ' ') r--;
        if (l > r) return false;
        else {
            char first = s.charAt(l), last = s.charAt(r);
            if (!(first == '+' || first == '-' || isStrNumber(first)) || !isStrNumber(last)) return false;
            l++;
            r--;
            boolean point = true, exponent = true;
            while (l <= r) {
                char c = s.charAt(l);
                if (c == 'e' && exponent) {
                    if (!isStrNumber(s.charAt(l - 1))) return false;
                    if (isStrNumber(s.charAt(l + 1)) || s.charAt(l + 1) == '+' || s.charAt(l + 1) == '-') {
                        int k = l + 2;
                        while (k <= r && isStrNumber(s.charAt(k))) {
                            k++;
                        }
                        if (k == l + 2 && !isStrNumber(s.charAt(l + 1))) return false;
                        else l = k;
                    }
                    exponent = false;
                } else if (c == '.' && point && exponent) {
                    if (!(isStrNumber(s.charAt(l - 1)) && isStrNumber(s.charAt(l + 1)))) return false;
                    point = false;
                    l += 2;
                } else if (isStrNumber(s.charAt(l))){
                    l++;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isStrNumber(char c) {
        return c >= '0' && c <= '9';
    }

    @Test
    public void isNumberTest() {
        System.out.println(isNumber(" "));
        System.out.println(isNumber("0")); // true
        System.out.println(isNumber(" 0.1")); // true
        System.out.println(isNumber("abc")); // false
        System.out.println(isNumber("1 a")); // false
        System.out.println(isNumber("2e10")); // true
        System.out.println(isNumber(" -90e3     ")); // true
        System.out.println(isNumber(" 1e")); // false
        System.out.println(isNumber("e3")); // false
        System.out.println(isNumber(" 6e-1")); // true
        System.out.println(isNumber(" 99e2.5 ")); // false
        System.out.println(isNumber("53.5e93")); // true
        System.out.println(isNumber(" --6 ")); // false
        System.out.println(isNumber("-+3")); // false
        System.out.println(isNumber("95a54e53")); // false
        System.out.println(isNumber(".1"));
        System.out.println(isNumber1("1."));
        System.out.println(isNumber1(".1"));
    }

    // 自动机
    public boolean isNumber1(String s) {
        int state = 1;
        s = s.trim();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '+' || c == '-') {
                if (state == 1 || state == 6) {
                    state++;
                } else {
                    return false;
                }
            } else if (c == '.') {
                if (state == 1 || state == 2) {
                    state = 3;
                } else if (state == 4) {
                    state = 9;
                } else {
                    return false;
                }
            } else if (c >= '0' && c <= '9') {
                if (state == 1 || state == 2 || state == 4) {
                    state = 4;
                } else if (state ==3 || state == 5 || state == 9) {
                    state = 5;
                } else if (state == 6 || state == 7 || state == 8) {
                    state = 8;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }

        return state == 4 || state == 5 || state == 8 || state == 9;
    }

    private int make(char c) {
        switch (c) {
            case '+':
            case '-': return 0;
            case 'e': return 2;
            case '.': return 3;
            default:
                if ('0' <= c && c <= '9') {
                    return 1;
                } else {
                    return -1;
                }
        }
    }

    public boolean isNumber2(String s) {
        int[][] dfa = {
                {1, 2, -1, 6},
                {-1, 2, -1, 6},
                {-1, 2, 3, 6},
                {4, 5, -1, -1},
                {-1, 5, -1, -1},
                {-1, 5, -1, -1},
                {-1, 7, 3, -1},
                {-1, 7, 3, -1}
        };
        int finals = 0b11100100;
        int state = 0, prevState = 0;
        char[] chars = s.trim().toCharArray();
        boolean flag = false;
        for (char c : chars) {
            int idx = make(c);
            if (idx < 0) return false;
            if (idx == 1) flag = true;
            prevState = state;
            state = dfa[state][idx];
            if (state < 0) return false;
            if (!flag && prevState == 6 && state == 3) return false;
        }
        return (finals & (1 << state)) > 0 && flag;
    }

    @Test
    public void isNumber2Test() {
        System.out.println(isNumber2("h"));
        System.out.println(isNumber2(" "));
        System.out.println(isNumber2("0")); // true
        System.out.println(isNumber2(" 0.1")); // true
        System.out.println(isNumber2("abc")); // false
        System.out.println(isNumber2("1 a")); // false
        System.out.println(isNumber2("2e10")); // true
        System.out.println(isNumber2(" -90e3     ")); // true
        System.out.println(isNumber2(" 1e")); // false
        System.out.println(isNumber2("e3")); // false
        System.out.println(isNumber2(" 6e-1")); // true
        System.out.println(isNumber2(" 99e2.5 ")); // false
        System.out.println(isNumber2("53.5e93")); // true
        System.out.println(isNumber2(" --6 ")); // false
        System.out.println(isNumber2("-+3")); // false
        System.out.println(isNumber2("95a54e53")); // false
        System.out.println(isNumber2(".1"));
        System.out.println(isNumber2("1."));
        System.out.println(isNumber2(".1"));
    }
}
