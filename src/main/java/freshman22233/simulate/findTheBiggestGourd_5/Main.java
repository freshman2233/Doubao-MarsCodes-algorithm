package freshman22233.simulate.findTheBiggestGourd_5;

/**
 * 5.Find the Biggest Gourd
 * In a classic Texas Hold'em game,
 * there is a card type called "Full House".
 * "Full House" consists of five cards,
 * including three cards of the same face value a
 * and two other cards of the same face value b.
 * If two people have "Full House" at the same time,
 * we will compare the cards first aa size,
 * if the card a If they are the same,
 * compare the cards again b The size of the card,
 * the rule of the face value of the card is:
 * 1 (A) > K > Q > J > 10 > 9 > ... > 2,
 * where the face value of 1 (A) is 1, K is 13, and so on.
 *
 * In this problem, we add a restriction to the "full house":
 * the sum of the face values of the five cards
 * that make up the "full house" cannot exceed the given maximum value max .
 *
 * Given a set of cards, you need to find the largest "full house" combination that conforms to the rules,
 * and output three of the same cards and two of the same cards.
 * If no matching "gourd" is found, "0, 0" is output.
 */
public class Main {
    public static int[] solution(int n, int max, int[] array) {
        // Edit your code here

        return new int[]{0, 0};
    }

    public static void main(String[] args) {
        // Add your test cases here
        /**
         * Note: 4 gourds can be formed in array array,
         * namely [6,6,6,8,8],[6,6,6,5,5],[8,8,8,6,6],[ 8,8,8,5,5].
         * Among them, the face value of [8,8,8,6,6] is 36.
         * If it is greater than 34, it does not meet the requirements.
         * The size relationship of the remaining three gourds is [8,8,8,5,5]>[6,6,6,8,8]>[6,6,6,5,5], so return [8 ,5]
         */
        System.out.println(java.util.Arrays.equals(solution(9, 34, new int[]{6, 6, 6, 8, 8, 8, 5, 5, 1}), new int[]{8, 5}));
        /**
         * Note: Two full houses can be formed, namely [9,9,9,6,6] and [6,6,6,9,9]. Since the face value of [9,9,9,6,6] is 39, greater than 37, so return [6,9]
         */
        System.out.println(java.util.Arrays.equals(solution(9, 37, new int[]{9, 9, 9, 9, 6, 6, 6, 6, 13}), new int[]{6, 9}));
        /**
         * Note: No gourd can be formed, so it returns [0,0]
         */
        System.out.println(java.util.Arrays.equals(solution(9, 40, new int[]{1, 11, 13, 12, 7, 8, 11, 5, 6}), new int[]{0, 0}));
    }
}
