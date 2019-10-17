package sort;

import java.util.Scanner;

public class SortInside {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int number;
		int sortedNumbers[] = new int[10];
		
		number = scan.nextInt();
		while(number > 0){
			sortedNumbers[number % 10]++;
			number /= 10;
		}
		
		for (int i= 9; i >= 0; i--) {
			for (int j = 0; j < sortedNumbers[i]; j++) {
				System.out.print(i);
			}
		}
		scan.close();
	}
}
