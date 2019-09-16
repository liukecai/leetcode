package cn.edu.kust.medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *
 * 17. Letter Combinations of a Phone Number
 * pass
 */
public class LetterCombinations {
    public List<String> letterCombinations(String digits) {
        Map<Character, String> digit2str = new HashMap<>();
        digit2str.put('2', "abc");
        digit2str.put('3', "def");
        digit2str.put('4', "ghi");
        digit2str.put('5', "jkl");
        digit2str.put('6', "mno");
        digit2str.put('7', "pqrs");
        digit2str.put('8', "tuv");
        digit2str.put('9', "wxyz");

        List<String> res = new LinkedList<>();

        for (Character ch : digits.toCharArray()) {
            if (res.size() == 0) {
                for (Character ch1 : digit2str.get(ch).toCharArray()) {
                    res.add(ch1.toString());
                }
                continue;
            }
            List<String> tmp = new LinkedList<>(res);
            res.clear();

            for (String str : tmp) {
                for (Character chd : digit2str.get(ch).toCharArray()) {
                    res.add(str + chd);
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        String input = "23";
        LetterCombinations lc = new LetterCombinations();
        System.out.println(lc.letterCombinations(input));
    }
}
