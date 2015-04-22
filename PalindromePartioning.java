package main;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by uarem on 4/21/2015.
 */
public class PalindromePartioning {

    public List<List<String>> partition(String s) {
        List<List<String>> partitons = new ArrayList<List<String>>();

        if (s.length() == 1) {
            List<String> partiton = new ArrayList<String>();
            partiton.add(s);
            partitons.add(partiton);

            return partitons;
        }


        for (int i=1; i<=s.length(); i++) {
            String subject = s.substring(0, i);
            if (isPalindrome(subject)) {
                if (i == s.length()) {
                    List<String> newList = new ArrayList<String>();
                    newList.add(s);
                    partitons.add(newList);
                } else {
                    List<List<String>> subPartition = partition(s.substring(i));
                    for (int j = 0; j < subPartition.size(); j++) {
                        List<String> sub = new ArrayList<String>();
                        sub.add(subject);
                        sub.addAll(subPartition.get(j));
                        partitons.add(sub);
                    }
                }
            }
        }

        return partitons;
    }

    private boolean isPalindrome(String s) {
        char[] input = s.toCharArray();
        for (int i=0; i<s.length()/2; i++) {
            if (input[i] != input[s.length()-1-i])
                return false;
        }
        return true;
    }
}
