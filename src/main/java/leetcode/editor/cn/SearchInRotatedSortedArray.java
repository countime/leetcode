package leetcode.editor.cn;
//假设按照升序排序的数组在预先未知的某个点上进行了旋转。 
//
// ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。 
//
// 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。 
//
// 你可以假设数组中不存在重复的元素。 
//
// 你的算法时间复杂度必须是 O(log n) 级别。 
//
// 示例 1: 
//
// 输入: nums = [4,5,6,7,0,1,2], target = 0
//输出: 4
// 
//
// 示例 2: 
//
// 输入: nums = [4,5,6,7,0,1,2], target = 3
//输出: -1 
// Related Topics 数组 二分查找 
// 👍 923 👎 0

public class SearchInRotatedSortedArray {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int target;
        int[] nums;

        public int search(int[] nums, int target) {
            this.target = target;
            this.nums = nums;
            int mid = nums.length / 2;
            //左侧有序
//            return search(0, nums.length - 1);
            return search3(nums, target);
        }

        public int search(int i, int j) {
            int mid = (i + j) / 2;
            if (mid == i) {
                if (target == nums[i]) {
                    return i;
                }
                return -1;
            }
            //左侧有序
            if (nums[i] < nums[mid]) {
                if (target >= nums[0] && target <= nums[mid]) {
                    return search(i, mid);
                } else {
                    return search(mid + 1, j);
                }
            } else {
                //右侧有序
                if (target >= nums[mid] && target <= nums[j]) {
                    return search(mid, j);
                } else {
                    return search(i, mid - 1);
                }
            }
        }

        public int search2(int[] nums, int target) {
            if (nums.length == 0) {
                return -1;
            }
            if (nums.length == 1) {
                return target==nums[0]?0:-1;
            }

            int l=0,r=nums.length-1;
            while (l <= r) {
                int mid=(l+r)/2;
                if (nums[mid] == target) {
                    return mid;
                }

                //左侧有序
                if (nums[l] < nums[mid]) {
                    if (target >= nums[l] && target < nums[mid]) {
                        r = mid-1;
                    } else {
                        l=mid+1;
                    }

                }else{
                    //右侧有序
                    if (target > nums[mid] && target <= nums[r]) {
                        l=mid+1;
                    }else{
                        r=mid-1;
                    }
                }
            }
            return -1;
        }
        int search3(int[] nums, int target) {
            int n = (int)nums.length;
            if (n==0) return -1;
            if (n == 1) return nums[0] == target ? 0 : -1;
            int l = 0, r = n - 1;
            while (l <= r) {
                int mid = (l + r) / 2;
                if (nums[mid] == target) return mid;
                if (nums[0] <= nums[mid]) {
                    if (nums[0] <= target && target < nums[mid]) {
                        r = mid - 1;
                    } else {
                        l = mid + 1;
                    }
                } else {
                    if (nums[mid] < target && target <= nums[n - 1]) {
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
            }
            return -1;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution s = new SearchInRotatedSortedArray().new Solution();
//        System.out.println(s.search(new int[]{2, 3, 4, 5, 1}, 3));
        System.out.println(s.search(new int[]{3,1}, 1));
    }
}