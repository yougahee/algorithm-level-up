package level2;

import java.util.Arrays;

public class StockPrice {
    public static void main(String[] args) {

        int[] price = {1, 2, 3, 2, 3};

        StockPriceSolution stockPriceSolution = new StockPriceSolution();

        int[] arr = stockPriceSolution.solution(price);
        System.out.println(Arrays.toString(arr));
    }
}

class StockPriceSolution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            int cnt = 0;
            int price = prices[i];

            if (price == 1) {
                answer[i] = prices.length - i - 1;
                continue;
            }

            for (int j = i + 1; j < prices.length; j++) {
                int nextprice = prices[j];
                cnt++;
                answer[i] = cnt;

                if (price > nextprice) {
                    break;
                }

            }
        }

        return answer;
    }
}
