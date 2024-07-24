package WarnerBros;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DSARound {


    /*Given a map of string, List<Integer> , use streams to get map of string, max of the list of integers*/
    private static void streamsAndCollectors() {

        Map<String, List<Integer>> map = new HashMap<>();
        map.put("Dev", Arrays.asList(1000, 2000));
        map.put("Devbrat", Arrays.asList(3000, 4000));

        Map<String, Integer> result = map.entrySet().stream().collect(Collectors.toMap(x -> (String) x.getKey(), entry -> (Integer) entry.getValue().stream().max(Integer::compare).orElse(null)));
    }

    /*

    There is an integer array nums sorted in ascending order (with distinct values).

    Prior to being passed to your function`nums`is **possibly rotated** at an unknown pivot index`k`(`1 <= k < nums.length`) such that the resulting array is `[nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]`(0-indexed). For example,`[0,1,2,4,5,6,7]`might be rotated at pivot index`3`and become`[4,5,6,7,0,1,2]`.

    Given the array`nums` after the possible rotation and an integer `target`, return *the index of `target` if it is in* `nums`, or* `-1`if it is not in `nums`.

    Example 1:
    Input: nums = [4,5,6,7,0,1,2], target = 0
    Output: 4
     */

    private static void binarySearchInRotatedArray() {
        int[] nums = {7, 6, 5, 4, 3, 2, 1};
        int target = 5;
        int n = nums.length;
        if (n == 0) {
            System.out.println("-1");
            return;
        }
        if (n == 1) {
            if (nums[0] == target) {
                System.out.println("0");
            }
            System.out.println("-1");
            return;
        }
        int pivot = findPivot(nums, 0, n - 1);
        System.out.println("Pivot : " + pivot);
        int index = binarySearch(nums, 0, pivot - 1, target);
        if (index == -1) {
            index = binarySearch(nums, pivot, n - 1, target);
        }
        System.out.println(index);
    }


    public static void main(String[] args) {

        streamsAndCollectors();

        binarySearchInRotatedArray();

    }

    private static int binarySearch(int[] nums, int l, int r, int target) {
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (target > nums[mid]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }


    private static int findPivot(int[] nums, int l, int r) {
        while (l < r) {
            int mid = l + (r - l) / 2;
            System.out.println("mid : " + mid + " for l : " + l + " for r : " + r);
            if (nums[mid] > nums[l]) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return r;
    }
}


