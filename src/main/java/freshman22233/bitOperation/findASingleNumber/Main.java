package freshman22233.bitOperation.findASingleNumber;

/**
 * 1-找单独的数
 * 问题描述
 * 在一个班级中，每位同学都拿到了一张卡片，上面有一个整数。
 * 有趣的是，除了一个数字之外，
 * 所有的数字都恰好出现了两次。
 * 现在需要你帮助班长小C快速找到那个拿了独特数字卡片的同学手上的数字是什么。
 * 要求：
 *     设计一个算法，使其时间复杂度为 O(n)，其中 n 是班级的人数。
 *     尽量减少额外空间的使用，以体现你的算法优化能力。
 * 测试样例
 * 样例1：
 *     输入：cards = [1, 1, 2, 2, 3, 3, 4, 5, 5]
 *     输出：4
 *     解释：拿到数字 4 的同学是唯一一个没有配对的。
 * 样例2：
 *     输入：cards = [0, 1, 0, 1, 2]
 *     输出：2
 *     解释：数字 2 只出现一次，是独特的卡片。
 * 样例3：
 *     输入：cards = [7, 3, 3, 7, 10]
 *     输出：10
 *     解释：10 是班级中唯一一个不重复的数字卡片。
 * 约束条件
 *     1 ≤ cards.length ≤ 1001
 *     0 ≤ cards[i] ≤ 1000
 *     班级人数为奇数
 *     除了一个数字卡片只出现一次外，其余每个数字卡片都恰好出现两次
 */

public class Main {
    public static int solution(int[] cards) {
        // Edit your code here
        int uniqueNumber = 0;
        for (int card : cards) {
            uniqueNumber ^= card;
        }
        return uniqueNumber;
    }

    public static void main(String[] args) {
        // Add your test cases here
        System.out.println(solution(new int[]{1, 1, 2, 2, 3, 3, 4, 5, 5}) == 4);
        System.out.println(solution(new int[]{0, 1, 0, 1, 2}) == 2);
    }

}

