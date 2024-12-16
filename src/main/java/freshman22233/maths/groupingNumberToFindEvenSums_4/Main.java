package freshman22233.maths.groupingNumberToFindEvenSums_4;

/**
 * Problem description
 * <p>
 * Little M faces a set of numbers from 1 to 9,
 * which are divided into multiple groups,
 * and selects a number from each group to form a new number.
 * The goal is to make the sum of the digits of this new number even.
 * The task is to work out how many different grouping and selection methods can achieve this goal.
 * <p>
 * numbers : A list of multiple integer strings,
 * each string can be treated as a group of numbers.
 * Little M needs to choose a number from each number group.
 * <p>
 * For example, for [123, 456, 789] , the 14 qualifying numbers are: 147 149 158 167 169 248 257 259 268 347 349 358 367 369 .
 */
public class Main {
    public static int solution(int[] numbers) {
        int waysEven = 1;
        int waysOdd = 0;
        //1.count the even and odd nums
        for (int num : numbers) {
            int evenCount = 0;
            int oddCount = 0;
            String numStr = String.valueOf(num);
            for (char ch : numStr.toCharArray()) {
                int digit = ch - '0';
                if (digit % 2 == 0) {
                    evenCount++;
                } else {
                    oddCount++;
                }
            }
            // 2.update waysEven
            int waysEvenNew = waysEven * evenCount + waysOdd * oddCount;
            int waysOddNew = waysOdd * evenCount + waysEven * oddCount;

            waysEven = waysEvenNew;
            waysOdd = waysOddNew;

        }
        return waysEven;
    }

    public static void main(String[] args) {
        // You can add more test cases here
        System.out.println(solution(new int[]{123, 456, 789}) == 14);
        System.out.println(solution(new int[]{123456789}) == 4);
        System.out.println(solution(new int[]{14329, 7568}) == 10);
    }
}