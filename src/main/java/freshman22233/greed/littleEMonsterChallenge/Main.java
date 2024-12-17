package freshman22233.greed.littleEMonsterChallenge;

/**
 * 6.Little E's Monster Challenge
 * Little E met in a game n monsters that appear in order.
 * Each monster has its own specific blood volume hi
 * and attack power ai.
 * Little E’s initial blood volume is H , the attack power is A .
 * The rules of the game are as follows:
 * 1. Little E can defeat monsters
 * whose blood volume and attack power are smaller than her current attributes.
 * 2. For each monster, Xiao E can choose to fight it or skip it.
 * 3. In order to maintain the rhythm of the battle,
 * in the sequence of monsters that are required to be defeated,
 * the blood volume and attack power of
 * the latter monster must be strictly greater than the previous monster.
 * Little E wants to know how many monsters she can defeat at most.
 *
 * enter
 * n : number of monsters
 * H : Little E’s blood volume
 * A : Little E’s attack power
 * h[i] : The blood volume of the i-th monster
 * a[i] : The attack power of the i-th monster
 * Output
 * Returns the maximum number of monsters that little E can defeat.
 * Constraints
 * 1 < n < 100
 * 1 < H,A,h[i],a[i] < 1000

 */
public class Main {
    public static int solution(int n, int H, int A, int[] h, int[] a) {
        //Find the monsters can be defeated
        int count  = 0;
        int[] hh = new int [n];
        int[] aa = new int [n];

        for (int i = 0; i < n; i++) {
            if (h[i] < H && a[i] < A) {
                hh[count] = h[i];
                aa[count] = a[i];
                count++;
            }
        }

        //If no monster left,return 0
        if (count == 0) {
            return 0;
        }

        //defined DP array
        int[] dp = new int[count];



        return 0;
    }

    public static void main(String[] args) {
        System.out.println(solution(3, 4, 5, new int[]{1, 2, 3}, new int[]{3, 2, 1}) == 1);
        System.out.println(solution(5, 10, 10, new int[]{6, 9, 12, 4, 7}, new int[]{8, 9, 10, 2, 5}) == 2);
        System.out.println(solution(4, 20, 25, new int[]{10, 15, 18, 22}, new int[]{12, 18, 20, 26}) == 3);
    }
}