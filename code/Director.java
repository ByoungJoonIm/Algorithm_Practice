package bruteforce;

import java.util.Scanner;

public class Director {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N;
		int counter = 0;
		int target = 0;
		
		N = scan.nextInt();
		
		/*
		 * algorithm
		 * */
		
		for (int i = 666; ; i++) {
			int temp = i;
			while(temp >= 666){
				if(temp % 1000 == 666){
					counter++;
					target = i;
					break;
				}
				temp = temp / 10;
			}
			if(N == counter)
				break;
		}
		System.out.println(target);
	}

}
