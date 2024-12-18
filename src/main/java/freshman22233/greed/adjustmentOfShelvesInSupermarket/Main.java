package freshman22233.greed.adjustmentOfShelvesInSupermarket;

/**
 * 9. Adjustment of shelves in supermarket
 * In a supermarket,
 * there is a store containing n A grid of goods racks,
 * each grid contains a kind of product,
 * and the products are represented by lowercase letters a to z .
 * When customers enter the supermarket,
 * they will search from the first grid to the n
 * Check out the grid to find the product you want to buy.
 * If the product is found in a certain grid,
 * the customer will buy it and leave;
 * if he encounters an empty grid in the middle,
 * or has searched all the grids without finding the desired product,
 * the customer will also leave.
 * As a supermarket manager,
 * you can rearrange the order of items
 * before customers arrive
 * to sell as many items as possible.
 * After the first customer enters,
 * the product position cannot be adjusted.
 * You need to calculate the maximum number of items
 * that can be sold under optimal adjustments.
 * Enter variable description:
 * n : Number of grids of the cargo rack
 * m : the number of product types the customer wants to purchase
 * s : the initial order of goods on the shelf
 * c : The type of product the customer wants to buy
 */
public class Main {
    public static int solution(int n, int m, String s, String c) {
        // Count frequencies of products in s
        int[] freq = new int[26];
        for (int i = 0; i < n; i++) {
            freq[s.charAt(i) - 'a']++;
        }

        // Try to serve requests in c
        int served = 0;
        for (int i = 0; i < m; i++) {
            int idx = c.charAt(i) - 'a';
            if (freq[idx] > 0) {
                freq[idx]--;
                served++;
            } else {
                break; // cannot serve this request
            }
        }

        return served;
    }

    public static void main(String[] args) {
        System.out.println(solution(3, 4, "abc", "abcd") == 3);
        System.out.println(solution(4, 2, "abbc", "bb") == 2);
        System.out.println(solution(5, 4, "bcdea", "abcd") == 4);
    }
}
