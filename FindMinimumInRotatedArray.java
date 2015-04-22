package main;

/**
 * Created by uarem on 4/19/2015.
 */
public class FindMinimumInRotatedArray {

    public int findMin(int[] nums) {
        int index = nums.length/2, base = 0;

        while(index < nums.length && nums.length != 1) {
            if (base + 1 == index && nums[base] > nums[index])
                return nums[index];
            if (nums[base] >= nums[index]) {
                int currentIndex = index;
                index = base + (int) Math.ceil((index - base) / 2.0);
                if (currentIndex == index) {
                    index++; base++;
                }
            }
            else { //(nums[base] < nums[index]
                int currentIndex = index;
                index = base + (int) Math.ceil(((index - base) * 3) / 2.0);
                base = currentIndex;
            }
        }
        return nums[0];
    }
}
