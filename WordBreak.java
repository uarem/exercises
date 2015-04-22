package main;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Created by uarem on 4/19/2015.
 */
public class WordBreak {
    public boolean wordBreak (String s, Set<String> wordDict) {
        Iterator<String> iterator = wordDict.iterator();
        StringBuffer sb = new StringBuffer(s);
        boolean result = false;

        while (iterator.hasNext()) {
            String dict = iterator.next();
            if (sb.toString().intern().startsWith(dict)) {
                if (sb.length() == dict.length())
                    return true;
                else if (s.substring(dict.length()).intern().contains(dict))
                    return false;
                else
                    result = wordBreak(sb.substring(dict.length()).toString(), wordDict);

                break;
            }
        }
        return result;
    }
}
