package test;

public class SubsetSumProblem {

    static int[] inputArr = {2,3,7,8,10};
    static int sum = 11;

    static boolean[][] dp = new boolean[inputArr.length][sum];

    public static void main(String[] args){
        boolean result = isSumPresent(inputArr.length - 1, sum);



    }

    private static boolean isSumPresent(int n, int sum) {

        boolean [][] dp = new boolean[n+1][sum+1];

        for(int i = 0; i < n+1; i++){
            for(int j = 0; j< sum+1; j++){
                if(i==0 && j==0){
                    dp[i][j] = true;
                } else if(i==0){
                    dp[i][j] = false;
                } else if(j==0){
                    dp[i][j] = true;
                } else{
                    if(dp[i-1][j] == true){
                        dp[i][j] = true;
                    } else{
                        int val = inputArr[i-1];
                        if(j>=val){
                            dp[i][j] = dp[i-1][j-val];
                        }
                    }
                }
            }
        }

        System.out.println(dp[n][sum]);

        return false;


    }
}
