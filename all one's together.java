class Solution {
    public int minSwaps(int[] nums) {
       
               int cnt1 = 0;
    int count1 = 0;
    int swaps;
    int ans = Integer.MAX_VALUE;

    // Count the total number of 1s in the array
    for (int num : nums) {
        if (num == 1) cnt1++;
    }

    // Count the number of 1s in the first window of size cnt1
    for (int i = 0; i < cnt1; i++) {
        if (nums[i] == 1) count1++;
    }

    // Initial number of swaps required to group 1s in the first window
    swaps = cnt1 - count1;
    ans = swaps;

    // Use sliding window to calculate minimum swaps for each window of size cnt1
    for (int i = 0; i < nums.length-1; i++) {
        if (nums[i  ] == 1) count1--;
        if (nums[(i + cnt1 ) % nums.length] == 1) count1++;

        swaps = cnt1 - count1;
        ans = Math.min(ans, swaps);
    }

    return ans;
    }
}