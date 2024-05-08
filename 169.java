//169. 多数元素
// 方法一：哈希表
//1. 我们使用哈希表来存储每个元素以及出现的次数。对于哈希表中的每个键值对，键表示一个元素，值表示该元素出现的次数。我们用一个循环遍历数组并将数组中的每个元素加入哈希表中。
//2. 在这之后，我们遍历数组时候使用打擂台的方法，维护最大的值。
class Solution {
    private Map<Integer, Integer> countNums(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        return map;
    }

    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = countNums(nums);
        Map.Entry<Integer, Integer> maxEntry = null;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (maxEntry == null || maxEntry.getValue() < entry.getValue()) {
                maxEntry = entry;
            }
        }
        return maxEntry.getKey();
    }
}
// 方法二：
//排序，出现次数大于n/2的元素肯定出现在排序后nums的[n/2]位置
class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
