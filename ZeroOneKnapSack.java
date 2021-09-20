package test;

public class ZeroOneKnapSack {


    static int[] wts = {1,4,3};
    static int[] profits = {2,4,4};

    static int capacity = 5;

    static int[][] dp = new int[capacity][wts.length];

    public static void main(String[] argv) {
        int profit = knapsack(capacity, wts.length);
        System.out.println("profit: " + profit);
    }

    public static int knapsack(int capacity, int n){

        if(dp[capacity][n] != 0){
            return dp[capacity][n];
        }

        if(capacity == 0 || n<0){
            return 0;
        }

        if(capacity < wts[n]){
            return knapsack(capacity, n-1);
        }

        int result = Math.max(profits[n] + knapsack(capacity - wts[n], n-1),
                knapsack(capacity, n-1));

        dp[capacity][n] = result;

        return result;
    }
}
