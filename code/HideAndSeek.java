package bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class HideAndSeek {		
	public static void main(String[] args) {
		final int maxValue = 100000;
		final int minValue = 0;
		Scanner scan = new Scanner(System.in);
		int arr[] = new int[maxValue + 1];
		Queue<Integer> queue = new LinkedList<Integer>();
		/*
		 * inputs
		 * */
		int N = scan.nextInt();
		int K = scan.nextInt();

		arr[N] = 1;		//we need to sub 1 from value as result.
		queue.add(N);
		/*
		 * bfs
		 * */
		while(arr[K] == 0){
			int temp = queue.poll();
			if(temp == K)
				break;
			if(temp - 1 >= minValue){
				if(arr[temp] + 1 < arr[temp - 1] || arr[temp - 1] == 0){
					arr[temp - 1] = arr[temp] + 1;
					queue.add(temp - 1);
				}
			}
			if(temp + 1 <= maxValue){
				if(arr[temp] + 1 < arr[temp + 1] || arr[temp + 1] == 0){
					arr[temp + 1] = arr[temp] + 1;
					queue.add(temp + 1);
				}
			}
			if(temp * 2 <= maxValue){
				if(arr[temp] + 1 < arr[temp * 2] || arr[temp * 2] == 0){
					arr[temp * 2] = arr[temp] + 1;
					queue.add(temp * 2);
				}
			}
		}
		System.out.println(arr[K] - 1);
	}
}
