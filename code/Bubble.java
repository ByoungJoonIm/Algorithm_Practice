package sort;

import java.util.Scanner;

public class Bubble {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N;
		int arr[];
		
		N = scan.nextInt();
		arr = new int[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = scan.nextInt();
		}
		
		/*
		 * algorithm
		 * */
		for (int i = N - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if(arr[j] > arr[j+1]){
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			System.out.println(arr[i]);
		}
	}

}
