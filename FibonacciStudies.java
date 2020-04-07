package techquestions;

import java.util.Arrays;

public class FibonacciStudies {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = 8;
		 
		System.out.println(fib(N));
	}
	
	public static int fib(int N) {
        if (N == 0) {
            return 0;
        }
        if (N == 1) {
            return 1;
        }
        if (N == 2) {
        	return 1;
        }
        
        int current = 0;
        // fib(2) :
        int prev1 = 1; // n - 1
        // fib(1) :
        int prev2 = 1; // n - 2
        
        for (int i = 3; i <= N; i++) {
        	current = prev1 + prev2;
        	prev2 = prev1;
        	prev1 = current;
        }
        
        return current;
	}

}
