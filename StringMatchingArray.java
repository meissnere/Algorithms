package techQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringMatchingArray {
    public static void main(String[] args) {
        String[] words = {"mass","as","hero","superhero"};
        List<String> output = stringMatching(words);
        System.out.println(output.toString());
    }

    public static List<String> stringMatching(String[] words) {
        Arrays.sort(words, (a, b)->Integer.compare(a.length(), b.length()));
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (words[j].contains(words[i]) && !list.contains(words[i])) {
                    list.add(words[i]);
                }
            }
        }
        return list;
    }
}
