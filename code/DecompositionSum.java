package bruteforce;

import java.util.Scanner;

public class DecompositionSum {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N;
		int rs = 0;
		
		N = scan.nextInt();
		
		for (int i = 1; i < N; i++) {
			int sum = i;
			int tmp = i;
			
			while(tmp > 0){
				sum += (tmp % 10);
				tmp /= 10;
			}
			
			if(sum == N){
				rs = i;
				break;
			}
		}
		System.out.println(rs);
		
	}

}
