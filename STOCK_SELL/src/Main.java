
public class Main {
    public static void main(String[] args) {
        int[] prices = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};

        int max = 0;
        int result = 0;
        int k = 0;

        for (int i = 0 ; i < prices.length - 1 ; i++){
            if (prices[i]<prices[i+1]){
                for (int j = i+1; j < prices.length  ; j++){
                    if (prices[j] - prices[i] >max ) {
                        max = prices[j] - prices[i];
                        if ( max > result) result = max;
                    }
                    k++;
                }
                max = 0;
            }

        }

        System.out.println(result + " " +k);

    }
}
