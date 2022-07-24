package codingTest.boj.sorting;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class boj2750 {
    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        // 1. Check Input Validation
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        if (n < 1 || n > 1000) {
            throw new Exception("Input is not valid");
        }
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            nums.add(Integer.parseInt(br.readLine()));
        }
        
        // 2. Biz Logic
        // _selectionSort(nums);
        // _selectionSort2(nums);
        // _insertionSort(nums);
        // _insertionSort2(nums);
        // _bubbleSort(nums);
        Collections.sort(nums);
        

        // 3. Print Output
        for (int num : nums) {
            System.out.println(num);
        }
    }

    private static List<Integer> _selectionSort(List<Integer> nums) throws Exception {
        // 1. Check input validation
        if (nums == null || nums.isEmpty()) {
            throw new Exception("_selectionSort input is not valid");
        }

        // 2. Biz logic
        int tmp = 0;
        int minIndex = 0;
        for (int i = 0; i < nums.size() - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < nums.size(); j++) {
                if (nums.get(j) < nums.get(minIndex)) {
                    // find min index
                    minIndex = j;
                }
            }
            // swap
            tmp = nums.get(i);
            nums.set(i, nums.get(minIndex));
            nums.set(minIndex, tmp);
        }

        // 3. End
        return nums;
    }

    /**
     * best : n^2
     * average : n^2
     * worst : n^2
     * memory : 1
     * stable : No
     * @param nums
     * @return
     * @throws Exception
     */
    private static List<Integer> _selectionSort2(List<Integer> nums) throws Exception {
        // 1. 입력값 검증
        if (nums == null || nums.isEmpty()) {
            throw new Exception("_selectionSort2 Input is not valid");
        }

        // 2. Biz logic
        int minIndex = 0;
        int inputSize = nums.size();
        int tmp = 0;
        for (int i = 0; i < inputSize - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < inputSize; j++) {
                if (nums.get(minIndex) > nums.get(j)) {
                    minIndex = j;
                }
            }
            // 현재 위치 == MIN이면, continue
            if (i == minIndex)
                continue;
            // swap
            tmp = nums.get(minIndex);
            nums.set(minIndex, nums.get(i));
            nums.set(i, tmp);
        }

        // 3. End
        return nums;
    }

    private static List<Integer> _insertionSort(List<Integer> nums) throws Exception {
        // 1. Check input validation
        if (nums == null || nums.isEmpty()) {
            throw new Exception("_insertionSort input is not valid");
        }

        // 2. Biz logic
        int tmp = 0;
        int minIndex = 0;
        for (int i = 1; i < nums.size(); i++) {
            minIndex = i;
            for (int j = i; j >= 0; j--) {
                if (nums.get(j) > nums.get(minIndex)) {
                    // swap
                    tmp = nums.get(minIndex);
                    nums.set(minIndex, nums.get(j));
                    nums.set(j, tmp);

                    minIndex = j;
                }
            }
        }

        return nums;
    }

    /**
     * best : n = 기 정렬 완료되어 있을 경우
     * average : n^2
     * worst : n^2
     * memory : 1
     * stable : Y
     * @param nums
     * @return
     * @throws Exception
     * 1) 모양 상으로 minIndex값이 1차 loop 안에서 점차 전진하는 구조이기에 버블 소트와 유사해보임
     * 2) stable sort이자, n^2(selection, bubble) sort 중에서는 빠른 편에 속한다
     */
    private static List<Integer> _insertionSort2(List<Integer> nums) throws Exception {
        // 1. 입력값 검증
        if (nums == null || nums.isEmpty()) {
            throw new Exception("_insertionSort2 input is not valid");
        }

        // 2. biz logic
        int minIndex = 0;
        int numsSize = nums.size();
        int tmp = 0;
        for (int i = 1; i < numsSize; i++) {
            minIndex = i;
            for (int j = i - 1; j >= 0; j--) {
                if (nums.get(minIndex) < nums.get(j)) {
                    // swap
                    tmp = nums.get(minIndex);
                    nums.set(minIndex, nums.get(j));
                    nums.set(j, tmp);

                    minIndex = j;
                } else {
                    // nums.get(minIndex)가 더 크다면, 더 이상 정렬할 필요가 없음
                    break;
                }
            }
        }

        // 3. end
        return nums;
    }

    /**
     * best : n = 1라운드 Swap 여부를 상태값으로 기록한다면, false일 경우 이미 정렬된 상태로 조건문을 통해 빠져나올 수 있음
     * average : n^2
     * worst : n^2
     * memory : 1
     * stable : Y
     * @param nums
     * @return
     * @throws Exception
     * n^2 Sort 중 가장 성능이 좋지 않음(swap이 자주 발생하기 때문)
     */
    private static List<Integer> _bubbleSort(List<Integer> nums) throws Exception {
        // 1. 입력값 검증
        if (nums == null || nums.isEmpty()) {
            throw new Exception("_bubbleSort input is not valid");
        }

        // 2. biz logic
        int tmp = 0;
        int numsSize = nums.size();
        for (int i = numsSize - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (nums.get(j) > nums.get(j + 1)) {
                    // swap
                    tmp = nums.get(j);
                    nums.set(j, nums.get(j + 1));
                    nums.set(j + 1, tmp);
                }
            }
        }

        // 3. end
        return nums;
    }
}
