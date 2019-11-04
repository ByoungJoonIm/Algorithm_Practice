package mathmatics;

import java.util.Scanner;

public class Sugar {
	private static void dynamic(){
		final int MAXVALUE = 5000;
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int d[][] = new int[3][N + 1];
		int packages[] = {0, 3, 5};
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j <= N; j++) {
				d[i][j] = MAXVALUE;
			}
		}
		
		d[0][0] = 0;
		for (int i = 1; i < 3; i++) {
			for (int j = 0; j <= N; j++) {
				if(packages[i] > j)
					d[i][j] = d[i - 1][j];
				else if(d[i - 1][j] > d[i][j - packages[i]] + 1)
					d[i][j] = d[i][j - packages[i]] + 1;
				else
					d[i][j] = d[i - 1][j];
			}
		}
		
		if(d[2][N] == MAXVALUE)
			System.out.println(-1);
		else
			System.out.println(d[2][N]);

	}
	
	/*
	 * x = 5의 갯수
	 * y = 3의 갯수
	 * 나머지	x			y
	 * 0	(N/5)		0
	 * 1	(N/5)-1		2
	 * 2	(N/5)-2		4
	 * 3	(N/5)		1
	 * 4	(N/5)-1		3
	 * 
	 * cf) (N/5)-1과 (N/5)-2가 음수가 되는 경우 (4와 7)은 별도로 고려해주어야함.
	 * */
	private static void math(){
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int x[] = {N /5, (N / 5) - 1, (N / 5) - 2, (N / 5), (N / 5) - 1};
		int y[] = {0, 2, 4, 1, 3};
		
		if(N == 4 || N == 7)
			System.out.println(-1);
		else
			System.out.println(x[N % 5] + y[N % 5]);
	}
	
	private static void math2(){
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		
		if(N == 4 || N == 7)
			System.out.println(-1);
		else {
			switch(N % 5){
			case 0:
				System.out.println(N/5);
				break;
			case 1:
			case 3:
				System.out.println(N/5 + 1);
				break;
			case 2:
			case 4:
				System.out.println(N/5 + 2);
				break;
			}	
		}
	}
	
	public static void main(String[] args) {
//		dynamic();
//		math();
		math2();
	}
}
