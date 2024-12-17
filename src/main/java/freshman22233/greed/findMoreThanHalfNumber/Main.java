package freshman22233.greed.findMoreThanHalfNumber;

/**
 * 8.Find the numbers that account for more than half of the integer
 * Little R selected some students from the class,
 * and each student gave a number.
 * It is known that among these numbers,
 * a certain digit appears more than half of the total number of digits.
 * Now you need to help Little R find this number.
 */

public class Main {
    public static int solution(int[] array) {
        int candidate = 0;
        int count = 0;

        // Boyer-Moore majority vote algorithm
        for (int num : array) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }

    public static void main(String[] args) {
        // Test case as provided
        System.out.println(solution(new int[]{1, 3, 8, 2, 3, 1, 3, 3, 3}) == 3);
    }
}
