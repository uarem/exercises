package main;

import java.util.*;

/**
 * Created by uarem on 4/18/2015.
 */
public class RepeatedDnaSequences {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<Integer> sequences = new HashSet<Integer>();
        List<String> result = new ArrayList<String>();

        for (int i=0; i<s.length()-9; i++) {
            int key = getHashCode(s.substring(i, i+10));
            String subString = s.substring(i, i+10);
            if (sequences.contains(key) && !result.contains(subString))
                result.add(subString);
            else
                sequences.add(key);
        }

        return result;
    }

    private int getHashCode(String key) {
        int hash = 0;
        for (int i=0; i<key.length(); i++)
            hash = hash << 2 | getCode(key.charAt(i));
        return hash;
    }

    int getCode(char c) {
        if (c == 'A') {
            return 0;
        } else if (c == 'C') {
            return 1;
        } else if (c == 'G') {
            return 2;
        }
        return 3;
    }
}
