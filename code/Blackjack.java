package bruteforce;

import java.util.Scanner;

public class Blackjack {

	public static void main(String[] args) {
		/*
		 * inputs
		 * */
		Scanner scan = new Scanner(System.in);
		int N;	//the number of 
		int M;	//target number
		int cards[];
		int fitNum = 0;
		
		N = scan.nextInt();
		M = scan.nextInt();
		cards = new int[N];
		
		for (int i = 0; i < N; i++) {
			cards[i] = scan.nextInt();
		}
		
		/*
		 * algorithm
		 * */
		for (int i = 0; i < N - 2; i++) {
			for (int j = i + 1; j < N - 1; j++) {
				for (int k = j + 1; k < N; k++) {
					int tmp = cards[i] + cards[j] + cards[k];
					if(tmp > fitNum){
						if(tmp <= M){
							fitNum = tmp;
						}
					}
				}
			}
		}
		
		System.out.println(fitNum);
		
	}

}
