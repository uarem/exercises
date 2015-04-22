package main;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by uarem on 4/18/2015.
 */
public class UglyNumber {

    public int getUglyNumber(int n) {
        Set<Integer> pool = new HashSet<Integer>();
        pool.addAll(Arrays.asList(1,2,3,5));
        int ugly = 0;

        for (int i=1; i<=n; i++) {
            ugly = min(pool.toArray()); //get minmum of pool
            pool.remove(ugly);
            pool.addAll(Arrays.asList(ugly*2, ugly*3, ugly*5));
        }
        return ugly;
    }

    private int min(Object[] array) {
        Arrays.sort(array);
        return (Integer) array[0];
    }
}
