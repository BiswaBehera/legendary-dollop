package com.biswa.dsa.code.random;

import static com.biswa.dsa.util.GenericUtils.swap;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

// https://leetcode.com/problems/first-missing-positive/description/
public class FirstMissingPositive {

  public int firstMissingPositive(int[] nums) {

    PriorityQueue<Integer> list = new PriorityQueue<>();
    Set<Integer> numSet = new HashSet<>();

    for (int i: nums) {
      if (!numSet.contains(i) && i > 0) {
        list.add(i);
        numSet.add(i);
      }
    }

    int missing = 1;
    while (!list.isEmpty()) {
      int i = list.poll();
      if (i != missing) break;
      missing++;
    }

    return missing;
  }

  public static void main(String[] args) {
    int[] arr = {1,2,6,3,5,1};
    System.out.println(new FirstMissingPositive().firstMissingPositiveI(arr));
  }

  public int firstMissingPositiveI(int[] nums) {

    int i = 0;
    while(i < nums.length) {
      int correct = nums[i] - 1;
      if(nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[correct]) {
        swap(nums, i, correct);
      } else {
        i++;
      }
    }

    for (int index = 0 ; index < nums.length; index++) {
      if(nums[index] != index + 1) {
        return index + 1;
      }
    }

    return nums.length + 1;
  }

  public int firstMissingPositiveII(int[] A, int n) {
    for(int i = 0; i < n; ++ i)
      while(A[i] > 0 && A[i] <= n && A[A[i] - 1] != A[i])
        swap(A, A[i], A[A[i] - 1]);

    for(int i = 0; i < n; ++ i)
      if(A[i] != i + 1)
        return i + 1;

    return n + 1;
  }

}
