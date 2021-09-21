package test1;


/*

Check if the winning condition is achieved

 4 8 9
 3 1 2
 7 5 X

WINNING CONDITION
 1 2 3
 4 5 7
 8 9 X

 */
public class Test1 {


    //static int[][] input = {{4,8,9},{3,1,2},{7,5,-1}};


    static int[][] input = {{1,2,3},{4,5,7},{-1,8,9}};

    public static void main(String[] args){
        boolean isWinningConditionAchieved = checkWinningCondition();
        System.out.println("isWinningConditionAchieved: "+ isWinningConditionAchieved);
    }

    private static boolean checkWinningCondition() {

        int previous = input[0][0];
        int current = input[0][1];
        int n = input.length;
        if(input[n-1][n-1] != -1){
            return false;
        }

        for(int i=0; i < n; i++){
            for(int j=0; j < n; j++){
                if(current < previous){
                    return false;
                }
                previous = current;
                current = input[i][j];
            }
        }

        return true;
    }
}
