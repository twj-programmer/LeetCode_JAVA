//80. 删除有序数组中的重复项 II
//数组是有序的
/**双指针法
 * i为答案数组的最后一个元素的下标
 * j代表待判断元素
 * 加入答案数组有两种情况：
 * 1.最后一个元素与待判定元素相同且与前一元素不同
 * 2.最后一个元素与待判定元素不同
 */
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2)
            return nums.length;
        int i = 1, j = 2;
        while (j < nums.length) {
            if (nums[i] == nums[j] && nums[i] != nums[i - 1])
                nums[++i] = nums[j];
            if (nums[i] != nums[j])
                nums[++i] = nums[j];
            j++;
        }
        return i + 1;
    }
}
/**双指针法优化
 * i代表答案数组的最后一个元素的后一个
 * j代表待判断元素
 * 现在直接判断nums[j]与nums[i - 2]是否相同，因为：
 * nums[j]==nums[i - 2]，则有nums[i - 2]==nums[i - 1]==nums[j]，此时nums[i]不能等于nums[j] 
 */
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2)
            return nums.length;
        int i = 2, j = 2;
        while (j < nums.length) {
            if (nums[i - 2] != nums[j])
                nums[i++] = nums[j];
            j++;
        }
        return i;
    }
}
