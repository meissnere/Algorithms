package techQuestions;


import java.util.Arrays;

public class ShuffleCards {
    public static void main(String[] args) {
        int arr[] = new int[52];
        for (int i = 0; i < 52; i++) {
            arr[i] = i;
        }
        int shuffled[] = randomShuffle(arr);
        System.out.println(Arrays.toString(shuffled));
     }

     public static int[] randomShuffle(int[] cards) {
         System.out.println(Math.random());
         System.out.println((int) (0.8662102668596056 * 52));
         for (int i = 0; i < 52; i++) {
             int card = (int) (Math.random() * 52); // 45
             int temp = cards[i]; // value = 0
             cards[i] = cards[card]; // cards[0] = 45
             cards[card] = temp; // cards[45] = 0
         }
         return cards;
     }
}
