package main;

import java.util.Arrays;

/**
 * Created by uarem on 4/18/2015.
 */
public class LargestNumber {


    public String largestNumber(int[] nums) {
        FormattedNumber[] numbers = new FormattedNumber[nums.length];
        for (int i = 0; i < nums.length; i++) {
            FormattedNumber newNumber = new FormattedNumber(String.valueOf(nums[i]));
            numbers[i] = newNumber;
        }
        Arrays.sort(numbers);
        StringBuffer sb = new StringBuffer();
        for (FormattedNumber f : numbers) sb.append(f);
        return sb.toString();
    }

    class FormattedNumber implements Comparable<FormattedNumber> {
        String number;

        public FormattedNumber(String assign) {
            number = assign;
        }

        @Override
        public String toString() {
            return number;
        }

        @Override
        public int compareTo(FormattedNumber o) {
            int shortLength = (this.number.length() > o.number.length()) ? o.number.length() : this.number.length();

            for (int i=0; i<shortLength; i++) {
                int compareResult = Integer.compare(Character.getNumericValue(o.number.charAt(i)) , Character.getNumericValue(this.number.charAt(i)));

                if (compareResult != 0)
                    return compareResult;
                else
                    continue;
            }

            int lengthCompare = Integer.compare(o.number.length(), this.number.length());
            if (lengthCompare == 0)
                return 0;
            else if (lengthCompare == 1) {
                int compare = Integer.compare(Character.getNumericValue(o.number.charAt(0)), Character.getNumericValue(this.number.charAt(shortLength)));
                if (compare == 0)
                    return -1;
                else
                    return compare;
            } else {
                int compare = Integer.compare(Character.getNumericValue(o.number.charAt(0)), Character.getNumericValue(this.number.charAt(shortLength)));
                if (compare == 0)
                    return -1;
                else
                    return compare;
            }

        }
    }
}
