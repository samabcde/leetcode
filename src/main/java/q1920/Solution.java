package q1920;

class Solution {
    //    Given a zero-based permutation nums (0-indexed),
    //    build an array ans of the same length
    //    where ans[i] = nums[nums[i]]
    //    for each 0 <= i < nums.length and return it.
    //
    //    A zero-based permutation nums is an array of distinct integers from 0 to nums.length - 1 (inclusive).
    //    1 <= nums.length <= 1000
    //    0 <= nums[i] < nums.length
    //    The elements in nums are distinct.
    //    {2, 1, 0}->{0 ,1, 2}
    //    {2, 0, 1}->{1 ,2, 0}
    public int[] buildArray(int[] nums) {
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = nums[nums[i]];
        }
        return ans;
    }
}