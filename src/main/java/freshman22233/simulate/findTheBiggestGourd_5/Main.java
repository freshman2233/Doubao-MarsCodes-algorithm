package freshman22233.simulate.findTheBiggestGourd_5;

import java.util.*;

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
        // Frequency map for the cards
        HashMap<Integer, Integer> freq = new HashMap<Integer, Integer>();
        for (int card : array){
            // find the value of card, if find put [card, value+1],if don't find, put [card 1]
            freq.put(card, freq.getOrDefault(card, 0) + 1);
        }

        //lists for candidates
        List<Integer> triples = new ArrayList<Integer>();
        List<Integer> pairs = new ArrayList<Integer>();

        //Identify triples and pairs
        for (Map.Entry<Integer,Integer> entry : freq.entrySet()){
            int card = entry.getKey();
            int count = entry.getValue();
            if (count >= 3){
                triples.add(card);
            }
            if (count >=2){
                pairs.add(card);
            }
        }

        int bestTriple = 0;
        int bestPair = 0;
        boolean found = false;

        //Try all full houses
        for (int t : triples){
            for (int p : pairs){
                if (t == p){
                    continue;
                }
                int sum = 3 * t + 2 * p;
                if (sum <= max){
                    // check if this full house is better than the current best
                    if(!found){
                        bestTriple = t;
                        bestPair = p;
                        found = true;
                    } else {
                        // compare (bestTriple,bestPair) with (t,p)
                        if(getRank(t)>getRank(bestTriple)){
                            bestTriple = t;
                            bestPair = p;
                        }else if(getRank(t)==getRank(bestTriple)){
                            if (getRank(p)>getRank(bestPair)){
                                bestTriple = t;
                                bestPair = p;
                            }
                        }
                    }
                }
            }
        }
        if(!found){
            return new int[]{0, 0};
        }
        return new int[]{bestTriple, bestPair};
    }

    private static int getRank(int card){
        if (card == 1){
            return 14;
        } else {
            return card;
        }
    }

    public static void main(String[] args) {
        // Add your test cases here
        System.out.println(java.util.Arrays.equals(solution(31, 42, new int[]{3,3,11,12,12,2,13,5,13,1,13,8,8,1,8,13,12,9,2,11,3,5,8,11,1,11,1,5,4,2,5}), new int[]{1, 13}));
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
