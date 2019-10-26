package dynamicProgramming;

import java.util.Scanner;

public class MakeAsOne {
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int d[] = new int[N + 1];
		
		for (int i = 2; i <= N; i++) {
			d[i] = d[i - 1] + 1;
			if(i % 3 == 0){
				if(d[i / 3] + 1 < d[i])
					d[i] = d[i / 3] + 1;
			}
				
			if(i % 2 == 0){
				if(d[i / 2] + 1 < d[i])
					d[i] = d[i / 2] + 1;
			}
		}
		System.out.println(d[N]);
		scan.close();
	}
}