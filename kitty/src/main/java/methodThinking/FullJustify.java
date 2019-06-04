package methodThinking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FullJustify {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < words.length; ) {
            int length = words[i].length(), j = i + 1;
            while (j < words.length && length + words[j].length() + j - i <= maxWidth) {
                length += words[j].length();
                j++;
            }
            StringBuilder tmp = new StringBuilder();
            if (j == words.length) {
                for (int k = i; k < words.length; k++) {
                    if (k != words.length - 1) tmp.append(words[k]).append(' ');
                    else tmp.append(words[k]);
                }
                char[] space = new char[maxWidth - tmp.length()];
                Arrays.fill(space, ' ');
                tmp.append(new String(space));
            } else {
                int spaceCount = j - i > 1 ? j - i - 1 : 1;
                char[] space = new char[(maxWidth - length) / spaceCount];
                int overFlow = (maxWidth - length) % spaceCount;
                Arrays.fill(space, ' ');
                for (int k = i; k < j; k++) {
                    if (k == j - 1) {
                        tmp.append(words[k]);
                        if (i == j - 1) tmp.append(new String(space));
                    }
                    else {
                        tmp.append(words[k]).append(new String(space));
                        if (overFlow-- > 0) tmp.append(' ');
                    }
                }
            }
            res.add(tmp.toString());
            i = j;
        }
        return res;
    }

    @Test
    public void test() {
        for (String str : fullJustify(new String[] {"This", "is", "an", "example", "of", "text", "justification."}, 16)) {
            System.out.println(str);
        }
        for (String str : fullJustify(new String[] {"What","must","be","acknowledgment","shall","be"}, 16)) {
            System.out.println(str);
        }
        for (String str : fullJustify(new String[] {"ask","not","what","your","country","can","do","for","you","ask","what","you","can","do","for","your","country"}, 16)) {
            System.out.println(str);
        }
    }
}
