package level3;

public class Budget {
    public static void main(String[] args) {
        //int[] budgets = {120, 110, 140, 150};
        int[] budgets = {9, 8, 5, 6, 7};
        int M = 5;

        System.out.println(solution(budgets, M));
    }
    public static int solution(int[] budgets, int M) {
        int answer = 0;
        int left= 1, right=0, middle;
        long sum=0;

        for(int budget : budgets) {
            if(right < budget)
                right = budget;
            sum += budget;
        }

        if(sum <=M)
            return right;

        while (left < right) {
            sum=0;
            middle = (left + right + 1)/2;

            for(int budget : budgets) {
                if(middle < budget)
                    sum+= middle;
                else
                    sum+= budget;
            }

            if(sum > M)
                right = middle -1;
            else
                left = middle;

            answer = left;
        }
        return answer;
    }


    //가능한 한 최대
  /*  public static int solution(int[] budgets, int M) {
        int answer = 0, max =0;
        long sum=0;
        int right=0, left =0, middle=0;

        for(int budgetSum : budgets){
            sum += budgetSum;
            right = Math.max(budgetSum, max);
        }

        while (right >= left) {
            sum =0;
            middle = (right + left) /2;

            for(int budget : budgets){
                if(budget > middle)
                    sum += middle;
                else
                    sum += budget;
            }

            if(sum <= M)
            {
                answer = middle;
                left = middle+1;
            }
            else {
                right = middle -1;
            }
        }

        return answer;
    }*/
}
