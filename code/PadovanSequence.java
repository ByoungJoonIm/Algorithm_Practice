package dynamicProgramming;

import java.util.Scanner;

public class PadovanSequence {
	public static long padov[];

	private static void fillPadovan(int maxN){
		padov = new long[maxN + 1];
		for(int i = 1; i < 6; i++)
			padov[i] = (i / 4) + 1;	//1 1 1 2 2
		
		for (int i = 6; i < maxN + 1; i++)
			padov[i] = padov[i - 1] + padov[i - 5];
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int maxValue = -1;
		int T = scan.nextInt();
		int inputN[] = new int[T];
		
		for (int i = 0; i < T; i++) {
			inputN[i] = scan.nextInt();
			if(inputN[i] > maxValue)
				maxValue = inputN[i];
		}
		fillPadovan(maxValue);
		
		for (int i = 0; i < T; i++)
			System.out.println(padov[inputN[i]]);
		scan.close();
	}
}
