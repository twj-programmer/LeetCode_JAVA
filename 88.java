//88. 合并两个有序数组
//!非递减顺序!排列的整数数组
/**1.内置函数排序法:
 * 将nums2加到nums1
 * 用内置函数排序
 */
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }
        Arrays.sort(nums1);
    }
}
/**2.双指针法:
 * 从nums1的后面开始插入
 * 比较nums1和nums2,大的放入后面
 * 最后加入剩下的
 */
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, k = m + n - 1;
        while (i >= 0 || j >= 0) {
            if (i < 0) {
                nums1[k--] = nums2[j--];
                continue;
            }
            if (j < 0) {
                nums1[k--] = nums1[i--];
                continue;
            }
            if (nums1[i] >= nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
    }
}
